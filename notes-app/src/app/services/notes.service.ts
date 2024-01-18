import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Notes } from '../models/notes';
import { environment } from 'src/environments/environment.development';
import { Actions } from '../models/actions';

@Injectable({
  providedIn: 'root'
})
export class NotesService {

  constructor(private httpClient: HttpClient) { }

  addNote(notes: Notes) {
    let apiEndpoint = environment.notesApi + '/api/notes';
    return this.httpClient.post(apiEndpoint, notes);
  }

  getAllNotes() {
    let apiEndpoint = environment.notesApi + '/api/notes';
    return this.httpClient.get<Notes[]>(apiEndpoint);
  }

  getAllActions() {
    let apiEndpoint = environment.notesApi + '/api/actions';
    return this.httpClient.get<Actions[]>(apiEndpoint);
  }
}
