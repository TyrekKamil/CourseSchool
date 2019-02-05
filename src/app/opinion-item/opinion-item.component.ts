import { Component, OnInit, Input, EventEmitter, Output } from '@angular/core';
import { Opinion } from '../models/opinion';
import { OpinionService } from '../service/opinion.service';

@Component({
  selector: 'app-opinion-item',
  templateUrl: './opinion-item.component.html',
  styleUrls: ['./opinion-item.component.css']
})
export class OpinionItemComponent implements OnInit {
  @Input() opinion: Opinion;
  @Output() removeItem: EventEmitter<Opinion> = new EventEmitter();
  constructor(private opinionService: OpinionService) {}

  ngOnInit() {}

  remove(id) {
   
    this.opinionService.removeOpinion(id).subscribe(
      (data)=>{ console.log("success")
        this.listAllOpinions();
      }
    );
    window.location.reload();
  }


}
