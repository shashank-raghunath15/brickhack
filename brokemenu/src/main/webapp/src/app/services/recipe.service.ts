import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Recipe } from '../models/recipe';
import { User } from '../models/User';
import { Comment } from '../models/comment';

@Injectable()
export class RecipeService {

  constructor(private http: HttpClient) { }

  getAllRecipies(): Observable<Recipe[]> {
    return this.http.get<Recipe[]>('http://localhost:8080/getAllRecipes');
  }

  getRecipe(id: number): Observable<Recipe> {
    return this.http.get<Recipe>('http://localhost:4200/getRecipe/' + id);
  }

  like(id: number) {
    return this.http.put('http://localhost:4200/like', id);
  }

  comment(comment: Comment) {
    return this.http.post('http://localhost:4200/comment/', comment);
  }
}
