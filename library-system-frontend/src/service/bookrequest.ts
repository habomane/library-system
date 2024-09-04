import { RequestRequest, Request } from "../models";

const URL = import.meta.env.VITE_LIBRARY_SYSTEM_URL;

export async function getRequestByRequester(requestingUserId: string)
{
    const response = await fetch(`${URL}/request/?requester=${requestingUserId}`);
    if(response.status !== 200) { return null; }

    const data = await response.json();
    
    return data.map((item: { [x: string]: string; }) => {
        return new Request(item["requestId"], item["requestingUserId"], item["receivingUserId"], 
            item["status"], item["details"], item["dateCreated"]
        )
    })
}

export async function getRequestByReceiver(receivingUserId: string)
{
    const response = await fetch(`${URL}/request/?receiver=${receivingUserId}`);
    if(response.status !== 200) { return null; }

    const data = await response.json();
    
    return data.map((item: { [x: string]: string; }) => {
        return new Request(item["requestId"], item["requestingUserId"], item["receivingUserId"], 
            item["status"], item["details"], item["dateCreated"]
        )
    })
}

export async function getRequestByRequestId(requestId: string)
{
    const response = await fetch(`${URL}/request/${requestId}`);
    if(response.status !== 200) { return null; }

    const data = await response.json(); 
    return new Request(data["requestId"], data["requestingUserId"], data["receivingUserId"], 
        data["status"], data["details"], data["dateCreated"]
        )
}
export async function createNewRequest(request: RequestRequest)
{
    const options = {
        method: "POST",
        headers: {
          "Accept": "*/*",
          "Content-Type": "application/json"
        },
        body: JSON.stringify(request),
      };
    
      const response = await fetch(`${URL}/request/create`, options);
      if(response.status !== 201) { return null; }

      const data  = await response.json();
      return new Request(data["requestId"], data["requestingUserId"], data["receivingUserId"], 
        data["status"], data["details"], data["dateCreated"]
        );
}

export async function deleteRequest(requestId: string)
{
    const options = {
        method: "DELETE",
        headers: {
          "Accept": "*/*",
          "Content-Type": "application/json"
        }
      };
    
      const response = await fetch(`${URL}/request/delete/${requestId}`, options);
      if(response.status !== 202) { return null; }

      const data  = await response.json();
      return data;
}

export async function updateRequest(request: Request)
{
    const options = {
        method: "PUT",
        headers: {
          "Accept": "*/*",
          "Content-Type": "application/json"
        },
        body: JSON.stringify(request),
      };
    
      const response = await fetch(`${URL}/request/update`, options);
      if(response.status !== 201) { return null; }

      const data  = await response.json();
      return new Request(data["requestId"], data["requestingUserId"], data["receivingUserId"], 
        data["status"], data["details"], data["dateCreated"]
        );
}