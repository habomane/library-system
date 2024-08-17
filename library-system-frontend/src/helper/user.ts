import { User } from "../models";

export function getUserDetails()
{
    const userDetails = JSON.parse(localStorage.getItem("account") || '""');
    return new User(userDetails["pubKey"], userDetails["id"], userDetails["userName"], userDetails["description"])

}

export function userDetailsExist()
{
    return JSON.parse(localStorage.getItem("account") || '""') === "" ? false : true;
}