import { Component, OnInit } from '@angular/core';
import { OpinionService } from '../service/opinion.service';
import { Opinion } from '../models/opinion';
import { numb } from '../models/numb';

@Component({
  selector: 'app-opinion-list',
  templateUrl: './opinion-list.component.html',
  styleUrls: ['./opinion-list.component.css']
})
export class OpinionListComponent implements OnInit {
  opinions: Opinion[];

  constructor(private opinionService: OpinionService) {}

  ngOnInit() {
    this.getOpinions();
  }


  public removeOpinion(opinion: Opinion) {
    console.log(opinion, 'remove');
    this.opinionService.removeOpinion(opinion).subscribe(res => {
      this.opinions = this.opinions.filter(el => el.getId() !== opinion.getId());
    });
  }
  private getOpinions() {
    this.opinionService.getAllOpinions().subscribe(res => {
      this.opinions = res;
    });
  }
}
