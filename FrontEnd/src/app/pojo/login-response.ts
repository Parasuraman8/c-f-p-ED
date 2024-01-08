import { Roles } from "./roles";

export class LoginResponse {
    username?:string;
    edRolesEntities?: Roles;
    jwtToken?:string;

    setUseName(user:string){
        this.username = user;
    }

    setToken(token:string){
        this.jwtToken = token;
    }

    getToken() {
        return this.jwtToken;
    }

    setRoles(role : Roles){
        this.edRolesEntities = role;
    }

    getRole(){
        return this.edRolesEntities?.role;
    }
}
