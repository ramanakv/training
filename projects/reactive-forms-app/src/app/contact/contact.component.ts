import { Component, OnInit } from "@angular/core";
import { FormControl, FormGroup, Validators } from "@angular/forms";

@Component({
  selector: "app-contact",
  templateUrl: "./contact.component.html",
  styleUrls: ["./contact.component.css"],
})
export class ContactComponent {
  countries = [
    {
      id: "IN",
      name: "India",
      cities: [
        { id: "DE", name: "Delhi" },
        { id: "MU", name: "Mumbai" },
        { id: "HY", name: "Hyderabad" },
        { id: "CH", name: "Chennai" },
      ],
    },
    {
      id: "US",
      name: "U S A",
      cities: [
        { id: "NY", name: "Los Angeles" },
        { id: "WA", name: "Washington" },
        { id: "FL", name: "Florida" },
        { id: "CH", name: "Chicago" },
      ],
    },
    {
      id: "UK",
      name: "United Kingdom",
      cities: [
        { id: "LO", name: "London" },
        { id: "MA", name: "Manchester" },
        { id: "ED", name: "Edinburgh" },
        { id: "LI", name: "Liverpool" },
      ],
    },
  ];

  contactForm = new FormGroup({
    name: new FormControl("", [Validators.required, Validators.minLength(5)]),
    gender: new FormControl(""),
    country: new FormControl("", Validators.required),
    city: new FormControl("", Validators.required),
  });
  
  cities = [];

  submitForm() {
    console.log(this.contactForm.value);
    console.table(this.contactForm.value);
  }

  getCities(countryId: string) {
    for (let c of this.countries) {
      if (countryId == c.id) {
        this.cities = c.cities;
      }
    }
  }

 
}

interface User {
  name: string;
  gender: string;
  country: string;
  city: string;
}
