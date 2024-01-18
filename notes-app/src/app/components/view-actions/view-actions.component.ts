import { Component, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Actions } from 'src/app/models/actions';
import { NotesService } from 'src/app/services/notes.service';

@Component({
  selector: 'app-view-actions',
  templateUrl: './view-actions.component.html',
  styleUrls: ['./view-actions.component.css']
})
export class ViewActionsComponent {
  displayedColumns: string[] = ['id', 'action', 'assignDate', 'completionDate', 'assignedTo'];
  actions = new MatTableDataSource<Actions>();
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  constructor(private notesService: NotesService) {

  }

  ngOnInit() {
    this.notesService.getAllActions().subscribe((data: Actions[]) => {
      if (data != null && data.length > 0) {
        this.actions = new MatTableDataSource(data);
        this.actions.paginator = this.paginator;
      }
    });
  }
}
