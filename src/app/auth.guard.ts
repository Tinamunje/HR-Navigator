import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';

export const authGuard: CanActivateFn = (route, state) => {
  const router = inject(Router);
  var r = localStorage.getItem('role');
  var token = localStorage.getItem("token");
  if(token !== null){
    if(r === 'EMPLOYEE'){
   
      return true;
    }
    else if(r === 'HR'){
   
      return true;
    }
    else{
      router.navigateByUrl('');
      return false;
    }
  }
  else{
    router.navigateByUrl('');
      return false;
  }
};

