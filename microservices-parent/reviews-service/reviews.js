const { MongoClient, ServerApiVersion } = require("mongodb");
const mongoose = require("mongoose");
const express = require("express");
const cors = require("cors");
const app = express();
const bodyParser = require("body-parser");
app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());
app.use(cors());
const Eureka = require("eureka-js-client").Eureka;

const eureka = new Eureka({
  instance: {
    app: "reviews-service",
    instanceId: "reviews-service",
    hostName: "reviews-service", // Change to your own hostname
    ipAddr: "127.0.0.1", // Change to your own IP address
    port: {
      $: 8001,
      "@enabled": "true",
    },
    vipAddress: "reviews-service",
    dataCenterInfo: {
      "@class": "com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo",
      name: "MyOwn",
    },
  },
  eureka: {
    host: "127.0.0.1", // Change to your Eureka server's hostname
    port: 8761, // Change to your Eureka server's port
    servicePath: "/eureka/apps/",
  },
});

eureka.logger.level("debug");
eureka.start((error) => {
  if (error) {
    console.log(`Error registering with Eureka: ${error}`);
  } else {
    console.log(`Registered with Eureka`);
  }
});

const uri =
  "mongodb+srv://mongo:mongo@clusterms.jzk5qbn.mongodb.net/?retryWrites=true&w=majority";

const client = new MongoClient(uri, {
  serverApi: {
    version: ServerApiVersion.v1,
    strict: true,
    deprecationErrors: true,
  },
});

(async () => {
  try {
    await client.connect();
    await client.db("admin").command({ ping: 1 });
    db = client.db("db");
    reviewsCollection = db.collection("reviews");
    console.log(
      "Pinged your deployment. You successfully connected to MongoDB!"
    );
    app.get("/api/reviews", async (req, res) => {
      await client.connect();
      const reviews = await reviewsCollection.find();
      const reviewsResult = await reviews.toArray();
      res.json(reviewsResult);
    });

    app.post("/api/reviews", async (req, res) => {
      const { product, rating, text } = req.body;

      await client.connect();
      const result = await reviewsCollection.insertOne({
        product,
        rating,
        text,
      });
      res.json(result);
    });
  } finally {
    await client.close();
  }
})().catch(console.dir);

const port = 8001;
app.listen(port, () => {
  console.log(`Server started on port ${port}`);
});
