import { Component, OnInit } from '@angular/core';
import { SpeakerService } from '../service/speaker.service';
import { Speaker } from '../models/speaker';
import { numb } from '../models/numb';

@Component({
  selector: 'app-speaker-list',
  templateUrl: './speaker-list.component.html',
  styleUrls: ['./speaker-list.component.css']
})
export class SpeakerListComponent implements OnInit {
  speakers: Speaker[];

  constructor(private speakerService: SpeakerService) {}

  ngOnInit() {
    this.getSpeakers();
  }


  public removeSpeaker(speaker: Speaker) {
    console.log(speaker, 'remove');
    this.speakerService.removeSpeaker(speaker).subscribe(res => {
      this.speakers = this.speakers.filter(el => el.getId() !== speaker.getId());
    });
  }
  private getSpeakers() {
    this.speakerService.getAllSpeakers().subscribe(res => {
      this.speakers = res;
    });
  }
}
