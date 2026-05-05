import { Component, inject } from '@angular/core';
import { TableModule } from 'primeng/table';
import { IFrame } from '@/models/IFrame';
import { FrameService } from '@/services/frame.service';

@Component({
    selector: 'app-frames',
    imports: [TableModule],
    templateUrl: './frames.component.html',
    styleUrl: './frames.component.scss'
})
export class FramesComponent {
    private frameService = inject(FrameService);

    frames: IFrame[] = [];

    ngOnInit(): void {
        this.frameService.getAll().subscribe((data) => {
            this.frames = data;
        });
    }
}
