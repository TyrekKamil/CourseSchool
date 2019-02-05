import { Component, OnInit, Input, EventEmitter, Output } from '@angular/core';
import { Speaker } from '../models/speaker';
import { SpeakerService } from '../service/speaker.service';

@Component({
  selector: 'app-speaker-item',
  templateUrl: './speaker-item.component.html',
  styleUrls: ['./speaker-item.component.css']
})
export class SpeakerItemComponent implements OnInit 
{ 
  @Input() speaker: Speaker; 
  @Output() removeItem: EventEmitter<Speaker> = new EventEmitter();
  constructor(private speakerService: SpeakerService) {}

  ngOnInit() {}

 remove(id) {
    this.speakerService.removeSpeaker(id).subscribe((data)=>{ console.log("success");
    window.location.reload();

  }

}
