import { Component, OnInit } from "@angular/core";
import { DialogService } from "primeng/dynamicdialog";
import { Observable, switchMap } from "rxjs";
import { Review } from "src/app/models/product.model";
import { ReviewsService } from "src/app/services/reviews.service";
import { AddReviewComponent } from "./add-reviews/add-review.component";

@Component({
  selector: "app-reviews",
  templateUrl: "./reviews.component.html",
  styleUrls: ["./reviews.component.scss"],
  providers: [DialogService],
})
export class ReviewsComponent implements OnInit {
  reviews$: Observable<Review[]>;

  constructor(
    private ReviewService: ReviewsService,
    public dialogService: DialogService
  ) {}

  ngOnInit(): void {
    this.getProducts();
  }

  addReview() {
    const ref = this.dialogService.open(AddReviewComponent, {
      header: "Add Product",
      width: "70%",
    });
    ref.onClose
      .pipe(switchMap((data: Review) => this.ReviewService.addReview(data)))
      .subscribe(this.getProducts);
  }

  getProducts() {
    this.reviews$ = this.ReviewService.getReviews();
  }
}
