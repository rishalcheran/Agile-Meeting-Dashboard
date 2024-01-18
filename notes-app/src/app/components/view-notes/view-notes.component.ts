import { Component, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Notes } from 'src/app/models/notes';
import { NotesService } from 'src/app/services/notes.service';

@Component({
  selector: 'app-view-notes',
  templateUrl: './view-notes.component.html',
  styleUrls: ['./view-notes.component.css']
})
export class ViewNotesComponent {
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  displayedColumns: string[] = ['id', 'title', 'notes', 'date', 'time', 'user'];
  notes = new MatTableDataSource<Notes>();
  constructor(private notesService: NotesService) {

  }

  ngOnInit() {
    this.notesService.getAllNotes().subscribe((data: Notes[]) => {
      if (data != null && data.length > 0) {
        this.notes = new MatTableDataSource(data);
        this.notes.paginator = this.paginator;
      }
    });
  }
}
