

import { Link } from "react-router-dom";
import { useState, useContext } from "react";
import { UserContext } from "../App";

function Header() {
    const [navOpenDisplay, toggleNavOpenDisplay] = useState(false);

    // Type Narrowing, can be null or what existed before
    const context = useContext(UserContext);

    if(!context)
    {
      return null;
    }
    const [user ] = context;



    const navClassName =
      navOpenDisplay === true
        ? "z-30 open block lg:hidden focus:outline-none hamburger"
        : "z-30 block lg:hidden focus:outline-none hamburger";
    const itemOpenDisplay =
      navOpenDisplay === true
        ? "absolute fixed p-6 bg-gray-50 flex flex-col py-20 items-center gap-y-5 w-[100vw] h-[100vh] top-0 left-0 z-100 transition-all lg:hidden"
        : "hidden";
    const regularNavDisplay = 
    navOpenDisplay === true ? "hidden": "hidden lg:flex flex flex-row justify-between w-[25%]";
    const toggleDisplay = () => toggleNavOpenDisplay(!navOpenDisplay);

    return (
      <nav className="container mx-auto font-head py-5 px-10 lg:px-2 flex justify-between items-center">
          <Link to={user.id === 0 ? "/" : "/library"}><p className="text-lg font-bold uppercase tracking-wide	"><span className=" text-green-700">Community</span> Library</p></Link>

          <div onClick={toggleDisplay}>
          <button id="menu-btn" className={navClassName + " mr-10"}>
            <span className="hamburger-top"></span>
            <span className="hamburger-middle"></span>
            <span className="hamburger-bottom"></span>
          </button>
        </div>


        <div className={regularNavDisplay}>
            <Link to="/library"><p className="cursor font-medium hover:underline hover:underline-offset-8 active:text-green-700">My Library</p></Link>
            <Link to="/discover"><p className="cursor font-medium hover:underline hover:underline-offset-8 active:text-green-700">Discover</p></Link>
            <Link to={user.id === 0 ? "/signup" : "/account/:" + user.id}><p className="cursor font-medium hover:underline hover:underline-offset-8 active:text-green-700">{user.id === 0 ? "Sign Up" : "Account"}</p></Link>
          </div>

          <div className={itemOpenDisplay}>
            <Link to="/library"
            ><p 
            onClick={() => toggleNavOpenDisplay(!navOpenDisplay)}
            className="cursor font-medium hover:underline hover:underline-offset-8 active:text-green-700">My Library</p></Link>
            <Link to="/discover"><p className="cursor font-medium hover:underline hover:underline-offset-8 active:text-green-700">Discover</p></Link>
            <Link to={user.id === 0 ? "/signup" : "/account/:" + user.id}>
            <p className="cursor font-medium hover:underline hover:underline-offset-8 active:text-green-700">{user.id === 0 ? "Sign Up" : "Account"}</p></Link>
          </div>
      </nav>
    );
  }
  
  export default Header;

