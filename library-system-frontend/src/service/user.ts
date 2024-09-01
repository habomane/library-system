import { User, UserRequest } from "../models";

const URL = import.meta.env.VITE_LIBRARY_SYSTEM_URL;

export async function createUser(user: UserRequest) {
  const options = {
    method: "POST",
    headers: {
      "Accept": "*/*",
      "Content-Type": "application/json"
    },
    body: JSON.stringify(user),
  };

  const data = await fetch(`${URL}/user/create`, options);
  const response = await data.json();

  return new User(
    response["privateKey"],
    response["userId"],
    response["displayName"],
    response["description"],
    response["dateCreation"]
  );
}

export async function getUserById(id: string) {
  const data = await fetch(`${URL}/user/id/${id}`);
  const response = await data.json();

  return new User(
    response["privateKey"],
    response["userId"],
    response["displayName"],
    response["description"],
    response["dateCreation"]
  );
}

export async function getUserByPrivateKey(privateKey: string) {
  const data = await fetch(`${URL}/user/privateKey/${privateKey}`);
  const response = await data.json();

    return new User(
      response["privateKey"],
      response["userId"],
      response["displayName"],
      response["description"],
      response["dateCreation"]
    );
}

export async function updateUser(user: User)
{
    const options = {
        method: "PUT",
        headers: {
          "Accept": "*/*",
          "Content-Type": "application/json"
        },
        body: JSON.stringify(user),
      };
    
      const data = await fetch(`${URL}/user/update`, options);
      const response = await data.json();
    
      return new User(
        response["privateKey"],
        response["userId"],
        response["displayName"],
        response["description"],
        response["dateCreation"]
      );
}

export async function deleteUser(userId: string)
{
    const options = {
        method: "DELETE",
        headers: {
          "Accept": "*/*",
          "Content-Type": "application/json"
        }
      };
    
      const data = await fetch(`${URL}/user/delete/${userId}`, options);
      return data;

}