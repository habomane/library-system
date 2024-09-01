import { User } from "../models";

export function getUserDetails()
{
    const userDetails = JSON.parse(localStorage.getItem("account") || '""');
    return new User(userDetails["privateKey"], userDetails["userId"], userDetails["displayName"], userDetails["description"], userDetails["dateCreation"])

}

export function userDetailsExist()
{
    return JSON.parse(localStorage.getItem("account") || '""') === "" ? false : true;
}

export function storeUserDetails(user: User)
{
    localStorage.setItem("account", JSON.stringify(user));
}

export function deleteUserDetails()
{
    localStorage.removeItem("account");
}

export function updateUserDetails(user: User)
{
    localStorage.removeItem("account");
    localStorage.setItem("account",JSON.stringify(user) );
}