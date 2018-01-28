import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Recipe } from '../models/recipe';

@Injectable()
export class RecipeService {

  constructor(private http: HttpClient) { }

  getAllRecipies(): Observable<Recipe[]> {
    return this.http.get<Recipe[]>('http://localhost:8080/getAllRecipes');
  }
}
