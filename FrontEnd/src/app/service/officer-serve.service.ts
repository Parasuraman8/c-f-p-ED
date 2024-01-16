import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CREATE_ED_OFFICER, GET_ALL_OFFICER, GET_ALL_USER_CREDENTIAL, GET_OFFICER_BY_ID, GET_USER_ALL_BANK, MODIFY_ED_OFFICER } from '../comman/constant';
import { credential } from '../comman/credential';

@Injectable({
  providedIn: 'root'
})
export class OfficerServeService {

  constructor(private http:HttpClient, private storage: credential) { }

  getOfficerById() :Observable<any> {
    return this.http.get<any>(GET_OFFICER_BY_ID+this.storage.getUsername());
  }

  getOfficerByEduId(id:any) : Observable<any> {
    return this.http.get<any>(GET_OFFICER_BY_ID+id);
  }

  updateOfficer(officerRequest:any):Observable<any> {
    const request = {
      "name": officerRequest.name,
      "gender": officerRequest.gender,
      "dob": officerRequest.dob,  
      "pho": officerRequest.pho,
      "gmail": officerRequest.gmail,
      "fname": officerRequest.fname,
      "adharNumber": officerRequest.adharNumber,
      "address": officerRequest.address,
      "qualification": officerRequest.qualification,
      "job": officerRequest.job,
      "jobPosition": officerRequest.jobPosition,
      "salary": officerRequest.salary,
      "jsd": officerRequest.jsd,
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
    console.log("before hit"+request);
    
    
    return this.http.put<any>(MODIFY_ED_OFFICER+officerRequest.edoid,request);
  }

  getAllOfficer() : Observable<any> {
    return this.http.get<any>(GET_ALL_OFFICER);
  }

  getAllCredential() : Observable<any> {
    return this.http.get<any>(GET_ALL_USER_CREDENTIAL);
  }

  getAllBank() : Observable <any> {
    return this.http.get<any>(GET_USER_ALL_BANK);
  }

  createOfficer(officerRequest:any) : Observable<any> {
    const request = {
      "name": officerRequest.name,
      "gender": officerRequest.gender,
      "dob": officerRequest.dob,  
      "pho": officerRequest.pho,
      "gmail": officerRequest.gmail,
      "fname":officerRequest.fname,
      "adharNumber": officerRequest.adharNumber,
      "address": officerRequest.address,
      "qualification": officerRequest.qualification,
      "job": officerRequest.job,
      "jobPosition": officerRequest.jobPosition,
      "salary": officerRequest.salary,
      "jsd": officerRequest.jsd,
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
    
    console.log(request)
    return this.http.post<any>(CREATE_ED_OFFICER,request);

  }
}
