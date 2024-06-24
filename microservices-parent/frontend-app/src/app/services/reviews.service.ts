import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { OAuthService } from "angular-oauth2-oidc";
import { Observable } from "rxjs";
import { Review } from "../models/product.model";

@Injectable({
  providedIn: "root",
})
export class ReviewsService {
  constructor(
    private httpClient: HttpClient
  ) {}

  getReviews(): Observable<Review[]> {
  
    return this.httpClient.get<Review[]>(
      "http://localhost:8001/api/reviews/"
    );
  }

  addReview(Review: Review): Observable<any> {
    return this.httpClient.post<any>(
      "http://localhost:8001/api/reviews/",
      Review
    );
  }
}
