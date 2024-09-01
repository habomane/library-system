import { Link, useNavigate } from "react-router-dom";
import { useState, useContext } from "react";
import * as userService from '../service'
import * as storage from '../helper'
import { UserContext } from "../App";

function LoginPage()
{
  const context = useContext(UserContext);
  const navigate = useNavigate();

  const [privateKey, setPrivateKey] = useState("");

  if(!context)
  {
    return null;
  }
  const [, setUser ] = context;



  async function retrieveUserInformation()
  {
    const userData = await userService.getUserByPrivateKey(privateKey);
    if (userData.userId === undefined) { alert("No account found. Please try again.")}
    else {
      storage.storeUserDetails(userData); 
      setUser(userData);
      navigate("/account/" + userData.userId);
    }
  }

   return (
    <main className="flex justify-center items-center w-full h-full">
        <div className="w-96 rounded-lg shadow-lg p-5 bg-green-700 text-white">
  <h2 className="text-2xl font-bold pb-5 text-center">Log In</h2>
  <label  className="block mb-2 text-sm font-medium">Private Key</label>
      <input
        type="text"
        id="name"
        className="bg-gray-100 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-2 focus:ring-blue-500 focus:border-blue-500 w-full py-2.5 px-4"
        placeholder="81dd200c8e404e3e4a006b6f2d09872a15da6defc6297c548733b0c339c8d953"
        required
        onChange={(e) => setPrivateKey(e.target.value)}
      />
    <div className="flex flex-col items-center gap-y-5 justify-between mb-4 mt-5">
      <button
        onClick={retrieveUserInformation}
        type="submit"
        className="text-white bg-black hover:bg-white hover:text-black focus:ring-2 focus:ring-blue-300 font-medium rounded-lg text-sm py-2.5 px-5 w-full sm:w-auto"
      >
        Login
      </button>
      <div className="flex items-center text-sm">
        <p>Don't have an account?</p>
        <Link to="/signup"><p className="underline cursor-pointer ml-1">Sign up</p></Link>
      </div>
      </div>
    </div>

    </main>)
}


export default LoginPage;