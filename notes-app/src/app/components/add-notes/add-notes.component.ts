import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { Notes } from 'src/app/models/notes';
import { NotesService } from 'src/app/services/notes.service';

@Component({
  selector: 'app-add-notes',
  templateUrl: './add-notes.component.html',
  styleUrls: ['./add-notes.component.css']
})
export class AddNotesComponent implements OnInit {

  addNotesForm!: FormGroup
  constructor(private notesService: NotesService, private _snackBar: MatSnackBar, private router: Router) {

  }

  ngOnInit() {
    this.addNotesForm = new FormGroup({
      title: new FormControl(),
      notes: new FormControl()
    });
  }
  createNotes() {
    let currentDate = new Date();
    let notesRequest: Notes = {

      title: this.addNotesForm.get('title')?.value,
      notes: this.addNotesForm.get('notes')?.value,
      date: currentDate.toLocaleDateString(),
      time: currentDate.toTimeString(),
      user: '',
      id: 0
    };

    this.notesService.addNote(notesRequest).subscribe(data => {
      if (data != null) {
        this._snackBar.open('Noted addedd Successfully!', 'Close', {
          horizontalPosition: 'center',
          verticalPosition: 'bottom',
          duration: 3000
        });
        this.router.navigateByUrl('/', { skipLocationChange: true })
          .then(() => this.router.navigate(['/add-notes']));
      }
    });
  }
}
