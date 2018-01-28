import { Component, OnInit } from '@angular/core';
import { RecipeService } from '../../services/recipe.service';
import { Recipe } from '../../models/recipe';
import { User } from '../../models/User';
import { Comment } from '../../models/comment';

@Component({
  selector: 'app-recipe',
  templateUrl: './recipe.component.html',
  styleUrls: ['./recipe.component.css']
})
export class RecipeComponent implements OnInit {

  private recipe: Recipe;
  private user: User;

  constructor(private recipeService: RecipeService) {
    recipeService.getRecipe(1).subscribe((recipe: Recipe) => {
      console.log(recipe);
      this.recipe = recipe;
    });
  }

  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem('user'));
  }

  like(id: number) {
    this.recipeService.like(id).subscribe(() => {
      this.ngOnInit();
    });
  }
  comment(comment: Comment) {
    this.recipeService.comment(comment).subscribe(() => {
      this.ngOnInit();
    });
  }
}
