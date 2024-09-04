import { useContext, useState, useEffect} from "react";
import { UserContext } from "../App";
import { User } from "../models";
import * as storage from '../helper'
import * as userService from '../service';
import { useNavigate } from "react-router-dom";

function AccountDetailsPage() {
  const navigate = useNavigate();
  const context = useContext(UserContext);
  const [displayName, setDisplayName] = useState("");
  const [description, setDescription] = useState("");
  const [isDisabled, setIsDisabled] = useState(true);

  if(!context)
  {
    return null;
  }
  const [user, setUser] = context;

  // eslint-disable-next-line react-hooks/rules-of-hooks
  useEffect(() => {
  setDescription(user.description);
  setDisplayName(user.displayName);
  }, [user])

  async function updateUser()
  {
    user.description = description;
    user.displayName = displayName;

    const updatedUser = await userService.updateUser(user);
    if(updatedUser.userId === undefined) { alert("Something went wrong. Please try again."); return;}
    setUser(updatedUser);
    storage.storeUserDetails(user);
    alert("Account has been updated");


  }

  async function deleteUser()
  {
    const result = await userService.deleteUser(user.userId);
    if(result.status === 202) { 
      alert("Account has been deleted")
      removeUserCredentials()
    }
  }

  function logOut()
  {

    alert("You have been logged out.")
    removeUserCredentials()

  }

  function removeUserCredentials()
  {
    storage.deleteUserDetails();
    setUser(new User("", "", "", "", "",));
    navigate("/");
  }

    return (
    <main className="container p-10 md:mx-auto">
      <section className="shadow-xl p-5 rounded-lg bg-white md:p-10 h-[75vh]">
        <input className="text-2xl font-semibold text-green-700"
        value={displayName}
        onChange={(e) => 
          {
            setIsDisabled(false);
            setDisplayName(e.target.value)
          }

        }/>
        <p className="text-md text-gray-600">Joined: {user.dateCreation.toDateString()}</p>
        <p className="text-lg font-semibold text-gray-900 mt-16">Description</p>
        <textarea className="text-lg bg-gray-100 py-2 rounded-lg px-1 mt-5 w-full"
        value={description}
        onChange={(e) => {
          setIsDisabled(false);
          setDescription(e.target.value)
        }
}
        />

        <div className="flex md:flex-row gap-x-5 mt-10">
        <button 
        disabled={isDisabled}
        onClick={updateUser}
        className="rounded-lg px-4 py-2 font-medium bg-green-300 hover:bg-green-700 hover:text-white duration-300">
         Update
              </button>
              <button 
        onClick={logOut}
        className="rounded-lg px-4 py-2 text-sm font-medium md:text-base bg-yellow-500 hover:bg-yellow-800 hover:text-white duration-300">
         Log Out
              </button>
        <button 
        onClick={deleteUser}
        className="rounded-lg px-4 py-1 font-medium bg-red-500 hover:bg-red-800 hover:text-white duration-300">Delete</button>

        </div>
      </section>

    </main>
    );
  }
  
  export default AccountDetailsPage;
  
/* eslint-enable */