import {ApplicationConfig, importProvidersFrom} from '@angular/core';
import {provideRouter} from '@angular/router';

import { routes } from './app.routes';
import {BrowserAnimationsModule, provideAnimations} from "@angular/platform-browser/animations";
import {provideHttpClient, withInterceptors} from "@angular/common/http";
import {authInterceptor} from "./auth/auth.interceptor";
import {provideAnimationsAsync} from "@angular/platform-browser/animations/async";




export const appConfig: ApplicationConfig = {
  providers: [
    importProvidersFrom(BrowserAnimationsModule),
    provideRouter(routes),
    provideAnimations(),
    provideHttpClient(withInterceptors(
      [authInterceptor],
    )),
    { provide: 'APP_BASE_HREF', useValue: '/demo/' }
  ]
};
