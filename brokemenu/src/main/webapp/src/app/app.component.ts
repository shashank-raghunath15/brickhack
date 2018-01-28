import { Component } from '@angular/core';
import { OnInit } from '@angular/core';
import { RecipeService } from './services/recipe.service';
import { Recipe } from './models/recipe';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  private recipes: Recipe[];
  constructor(private recipeService: RecipeService) {

  }

  ngOnInit() {
    this.recipeService.getAllRecipies().subscribe((recipes: Recipe[]) => {
        this.recipes = recipes;
    });
  }
  getAllRecipies() {

  }
}
