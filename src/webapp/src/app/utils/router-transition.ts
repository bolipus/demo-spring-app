import {trigger, transition, style, query, animate, group} from '@angular/animations';

export const routerTransition= [
  trigger('routerTransition', [
    transition('* <=> *', [
      query(':enter, :leave', style({ opacity: 1, position: 'fixed', width:'100%' }), { optional: true }),
      group([
        query(':enter', [
          style({ opacity: '0', transform: 'translateX(100%)' }),
          animate('500ms ease-in-out', style({ opacity: '1.0', transform: 'translateX(0%)'}))
        ], { optional: true}),
        query(':leave', [
          style({ opacity: '1.0',transform: 'translateX(0%)' }),
          animate('500ms ease-in-out', style({ opacity: '0.0', transform: 'translateX(-100%)' }))], { optional: true }),
      ])
    ])
  ])
]
