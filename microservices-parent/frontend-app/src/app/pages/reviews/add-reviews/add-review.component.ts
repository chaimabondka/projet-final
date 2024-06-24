import { Component, OnInit } from "@angular/core";
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { DynamicDialogRef } from "primeng/dynamicdialog";

@Component({
  selector: "app-add-review",
  templateUrl: "./add-review.component.html",
  styleUrls: ["./add-review.component.scss"],
})
export class AddReviewComponent implements OnInit {
  addReviwForm: FormGroup;

  constructor(public ref: DynamicDialogRef) {
    this.addReviwForm = new FormGroup({
      product: new FormControl("", Validators.required),
      rating: new FormControl("", Validators.required),
      text: new FormControl("", Validators.required),
    });
  }

  ngOnInit(): void {}

  submit() {
    const data = this.addReviwForm.value;
    if (this.addReviwForm.valid) {
      this.ref.close(data);
    } else {
      this.ref.close();
    }
  }
}
