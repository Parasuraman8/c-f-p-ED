import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CREATE_ED_ADMIN, CREATE_ED_ROLE, GET_ADMIN_BY_ID, GET_ALL_ADMIN, GET_ALL_ROLE, GET_ROLE_BY_ID, GET_USER_CREDENTIAL, MODIFY_ED_ADMIN, MODIFY_ED_ROLE, MODIFY_USER_CREDENTIAL } from '../comman/constant';
import { credential } from '../comman/credential';

@Injectable({
  providedIn: 'root'
})
export class AdminSerService {

  constructor(private http:HttpClient, private storage : credential) { }

  getAllRoles() : Observable<any> {
    return this.http.get<any>(GET_ALL_ROLE);
  }

  getCredential(id:string):Observable<any> {
    return this.http.get<any>(GET_USER_CREDENTIAL+id);
  }

  updateCredent(id:any,credend:any):Observable<any> {

   const request ={
    "password":credend.password,
    "edRolesModels":[
        {
            "role":credend.edRolesModels[0].role,
            "roleDesc":credend.edRolesModels[0].roleDesc
        }
    ]
}
    return this.http.put<any>(MODIFY_USER_CREDENTIAL+id,request);
  }

  getAllAdmin(): Observable<any> {
    return this.http.get<any>(GET_ALL_ADMIN);
  }

  getAdminById(hell:string):Observable<any> {
    return this.http.get<any>(GET_ADMIN_BY_ID+hell);
  }

  getAdmin() {
    return this.http.get<any>(GET_ADMIN_BY_ID+this.storage.getUsername());
  }

  createAdmin(adminRequest:any) {
    const request = {
      "name": adminRequest.name,
      "gender": adminRequest.gender,
      "pho": adminRequest.pho,
      "fname": adminRequest.fname,
      "adharNumber": adminRequest.adharNumber,
      "dob":  adminRequest.dob,  
      "gmail":  adminRequest.gmail,
      "edUserCredentials": [
          {
          "userName": "",
          "password": "",
          "edRolesModels": [
            {
              "role": "",
              "roleDesc": ""
            }
          ]
        }
       
      ]
    }
    
    return this.http.post<any>(CREATE_ED_ADMIN,request);
  }

  createRole(roleRequest:any):Observable<any> {
    const request = {
      "role":roleRequest.role,
      "roleDesc":roleRequest.roleDesc
    }
    return this.http.post<any>(CREATE_ED_ROLE,request);
  }

  updateRole(id:any,roleRequesr:any) : Observable<any> {
    const request = {
      "role":roleRequesr.role,
      "roleDesc":roleRequesr.roleDesc
    }
    return this.http.put<any>(MODIFY_ED_ROLE+id,request);
  }

  getRoleById(id:any) : Observable<any> {
    return this.http.get<any>(GET_ROLE_BY_ID+id);
  }

  updateAdmin(adminRrequest:any) : Observable<any> {

    const request = {
      "name": adminRrequest.name,
      "gender": adminRrequest.gender,
      "pho": adminRrequest.pho,
      "fname": adminRrequest.fname,
      "adharNumber": adminRrequest.adharNumber,
      "dob":  adminRrequest.dob,  
      "gmail":  adminRrequest.gmail,
      "edUserCredentials": [
          {
          "userName": "",
          "password": "",
          "edRolesModels": [
            {
              "role": "",
              "roleDesc": ""
            }
          ]
        }
       
      ]
    }

    console.log(adminRrequest);
    
    return this.http.put<any>(MODIFY_ED_ADMIN+adminRrequest.edaid,request);
  }
}
