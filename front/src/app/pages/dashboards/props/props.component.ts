import { Component, inject } from '@angular/core';
import { TableModule } from 'primeng/table';
import { IProp } from '@/models/IProp';
import { PropService } from '@/services/prop.service';

@Component({
    selector: 'app-props',
    imports: [TableModule],
    templateUrl: './props.component.html',
    styleUrl: './props.component.scss'
})
export class PropsComponent {
    private propService = inject(PropService);

    props: IProp[] = [];

    ngOnInit(): void {
        this.propService.getAll().subscribe((data) => {
            this.props = data;
        });
    }
}
