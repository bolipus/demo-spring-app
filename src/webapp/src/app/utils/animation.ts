import { trigger, transition, style, query, animate, group } from '@angular/animations';

export const routeAnimations = [
  trigger('routeAnimation', [
    transition('* <=> *', [
      style({ position: 'relative' }),
      query(
        ':enter, :leave',
        [
          style({
            position: 'absolute',
            top: 0,
            left: 0,
            width: '100%',
          }),
        ],
        { optional: true }
      ),
      query(':enter', [style({
                position: 'absolute',
                top: 0,
                left: 0,
                width: '100%' })],
        { optional: true }),
      group([
        query(
          ':leave',
          [animate('3000ms ease-out', style({ opacity: 0}))],
          { optional: true }
        ),
        query(
          ':enter',
          [animate('300ms ease-out', style({ opacity: 1,
            backgroundColor: 'black'}))],
          { optional: true }
        ),
      ]),
    ]),
  ]),
];