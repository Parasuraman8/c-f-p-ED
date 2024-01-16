export const LOGIN_URL = "http://localhost:9090/ED/EdJwtController/login";

export const CREATE_ED_USER = "http://localhost:9090/ED/UserController/createEdUser";

export const CREATE_ED_USER_PAYMENT = "http://localhost:9090/ED/UserController/createPayment";

export const DELETE_ED_USER = "http://localhost:9090/ED/UserController/deleteEdUser?eduid=";

export const GET_USER_ALL_BANK = "http://localhost:9090/ED/UserController/getAllBank";

export const GET_ALL_USER = "http://localhost:9090/ED/UserController/getAllUser";

export const GET_ALL_COMPLAINTS = "http://localhost:9090/ED/UserController/getAllComplaint?trueOrFalse=False";

export const GET_ALL_PAYMENTS = "http://localhost:9090/ED/UserController/getAllComplaint?trueOrFalse=True";

export const GET_USER_BY_ID = "http://localhost:9090/ED/UserController/getUser?eduid=";

export const GET_USER_BANK_BY_ID = "http://localhost:9090/ED/UserController/getBank?eduid=";

export const MODIFY_ED_USER = "http://localhost:9090/ED/UserController/modifyUser?eduid=";

export const MODIFY_ED_PAYMENT = "http://localhost:9090/ED/UserController/modifyPayment?value=";

export const MODIFY_ED_PAYMENT_ID = "&id=";

export const GET_USER_COMPLAINT = "http://localhost:9090/ED/UserController/userComplainList?eduid=";

export const GET_SENDER_DETIALS = "http://localhost:9090/ED/UserController/senderDetail?senderEduid=";

export const GET_RECEVIER_DETIALS = "http://localhost:9090/ED/UserController/reciverDetail?reciveEduid=";

export const TOTAL_NO_ROW_USER = "http://localhost:9090/ED/UserController/totalNumberOfRow";

export const CREATE_ED_OFFICER = "http://localhost:9090/ED/OfficerController/createOfficer";

export const DELETE_ED_OFFICER = "http://localhost:9090/ED/OfficerController/deleteOfficers?edoid=";

export const GET_ALL_OFFICER = "http://localhost:9090/ED/OfficerController/getAllOfficer";

export const GET_OFFICER_BY_ID = "http://localhost:9090/ED/OfficerController/getOfficer?edoid=";

export const MODIFY_ED_OFFICER = "http://localhost:9090/ED/OfficerController/modifyOfficer?edoid=";

export const TOTAL_NO_ROW_OFFICER = "http://localhost:9090/ED/OfficerController/totalNumberOfRow";

export const CREATE_ED_ADMIN = "http://localhost:9090/ED/AdminController/createAdmin";

export const CREATE_ED_ROLE = "http://localhost:9090/ED/AdminController/createRole";

export const GET_ADMIN_BY_ID = "http://localhost:9090/ED/AdminController/getAdmin?edaid=";

export const GET_ALL_ADMIN = "http://localhost:9090/ED/AdminController/getAllAdmin";

export const GET_ALL_ROLE = "http://localhost:9090/ED/AdminController/getAllRoles";

export const GET_ALL_USER_CREDENTIAL = "http://localhost:9090/ED/AdminController/getAllUserCredential";

export const GET_ROLE_BY_ID = "http://localhost:9090/ED/AdminController/getRole?roleName=";

export const GET_USER_CREDENTIAL = "http://localhost:9090/ED/AdminController/getUserCredential?userid=";

export const MODIFY_ED_ADMIN = "http://localhost:9090/ED/AdminController/modifyAdmin?edaid=";

export const MODIFY_ED_ROLE = "http://localhost:9090/ED/AdminController/modifyRole?roleName=";

export const MODIFY_USER_CREDENTIAL = "http://localhost:9090/ED/AdminController/modifyUserCredential?userid=";

export const DELETE_ED_ADMIN = "http://localhost:9090/ED/AdminController/removeAdmin?edaid=";

export const DELETE_ED_ROLE = "http://localhost:9090/ED/AdminController/removeRole?roleName=";

export const TOTAL_NO_ROW_ADMIN = "http://localhost:9090/ED/AdminController/totalNumberOfRow";