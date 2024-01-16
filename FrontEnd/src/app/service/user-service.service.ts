import { HttpClient } from '@angular/common/http';
import { Injectable, OnDestroy } from '@angular/core';
import { CREATE_ED_USER, CREATE_ED_USER_PAYMENT, DELETE_ED_USER, GET_ALL_COMPLAINTS, GET_ALL_PAYMENTS, GET_ALL_USER, GET_RECEVIER_DETIALS, GET_SENDER_DETIALS, GET_USER_BANK_BY_ID, GET_USER_BY_ID, GET_USER_COMPLAINT, MODIFY_ED_USER, TOTAL_NO_ROW_USER } from '../comman/constant';
import { credential } from '../comman/credential';
import { Observable, Subscription, observable } from 'rxjs';
import { PayRequest } from '../pojo/pay-request';
import { observableToBeFn } from 'rxjs/internal/testing/TestScheduler';
import { DataService } from './data-service.service';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService  {

 
  userInfoID : any;

  constructor( private sharedData : DataService, private storage:credential, private http:HttpClient) { 
    
  }

  getUser() : Observable<any> {
    return this.http.get<any>(GET_USER_BY_ID+this.storage.getUsername());
  }

  getUserByID(id:string) {
    return this.http.get<any> (GET_USER_BY_ID+id);
  }

  getUserHistory(): Observable<any>{
    return this.http.get<any>(GET_SENDER_DETIALS+this.storage.getUsername());
  }

  geSender() : Observable<any> {
    return this.http.get<any>(GET_USER_COMPLAINT+this.storage.getUsername());
  }

  getReciever() : Observable<any> {
    return this.http.get<any>(GET_RECEVIER_DETIALS+this.storage.getUsername());
  }

  payAmount(payRequs:PayRequest) : Observable<any> {
    return this.http.post<any>(CREATE_ED_USER_PAYMENT,payRequs);
  }

  getAllPayment() : Observable<any> {
    return this.http.get<any>(GET_ALL_PAYMENTS);
  }

  getAllComplaints() : Observable<any> {
    return this.http.get<any>(GET_ALL_COMPLAINTS);
  }

  getAllUser() : Observable<any> {
    return this.http.get<any>(GET_ALL_USER);
  }

  getSenderDetial(id:any) : Observable<any>  {
    return this.http.get<any>(GET_USER_BANK_BY_ID+id);
  }

  createUser(userRequest:any) : Observable<any> {
    const requset ={
      "name": userRequest.name,
      "gender": userRequest.gender,
      "dob": userRequest.dateOfBirth,
      "pho": userRequest.phone,
      "gmail": userRequest.gmail,
      "fname": userRequest.fatherName,
      "adharNumber": userRequest.adharNumber,
      "address": userRequest.address,
      "qualification": userRequest.qualification,
      "job": userRequest.workField,
      "jobPosition": userRequest.jobPosition,
      "salary": userRequest.salary,
      "jsd": userRequest.joinDate,
      "edUserCredentials": [
        {
          "userName": "",
          "password": "",
          "edRolesModels": [
            {
              "role": "EDU",
              "roleDesc": "user"
            }
          ]
        }
      ],
      "edUserBankEntities": [
        {
          "acctNo": userRequest.accountNumber,
          "bankCountry": userRequest.country,
          "bankName": userRequest.bankName,
          "branch": userRequest.bankBranch,
          "totalAmount": 500000,
          "acctStatus": userRequest.accountStatus
        }
      ]
    }
    
    return this.http.post<any>(CREATE_ED_USER,requset);    
  }

  updateUser(userRequest:any) : Observable<any>{
    const request = {
      "name": userRequest.name,
      "gender": userRequest.gender,
      "dob": userRequest.dob,
      "pho": userRequest.pho,
      "gmail": userRequest.gmail,
      "fname": userRequest.fname,
      "adharNumber": userRequest.adharNumber,
      "address": userRequest.address,
      "qualification": userRequest.qualification,
      "job": userRequest.job,
      "jobPosition": userRequest.jobPosition,
      "salary": userRequest.salary,
      "jsd": userRequest.jsd,
      "edUserCredentials": [
        {
          "userName": userRequest.eduid,
          "password": userRequest.dob,
          "edRolesModels": [
            {
              "role": "EDU",
              "roleDesc": "user"
            }
          ]
        }
      ],
      "edUserBankEntities": [
        {
          "acctNo": userRequest.edUserBankEntities[0].acctNo,
          "bankCountry":  userRequest.edUserBankEntities[0].bankCountry,
          "bankName":  userRequest.edUserBankEntities[0].bankName,
          "branch":  userRequest.edUserBankEntities[0].branch,
          "totalAmount":  userRequest.edUserBankEntities[0].totalAmount,
          "acctStatus":  userRequest.edUserBankEntities[0].acctStatus
        }
      ]
    }
    console.log("before hit : ",request)
    
    return this.http.put<any>(MODIFY_ED_USER+userRequest.eduid,request);

  }
}
