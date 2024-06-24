import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { OrderRequest } from "../models/order.model";

@Injectable({
  providedIn: "root",
})
export class OrderService {
  constructor(private httpClient: HttpClient) {}

  placeOrder(order: OrderRequest): Observable<string> {
    return this.httpClient.post<string>("http://localhost:9090/api/order", {order});
  }
}
