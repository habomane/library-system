import { useContext, useEffect } from "react";
import { UserContext } from "../App";


function AccountDetailsPage() {
    const [user, setUser] = useContext(UserContext);

    useEffect(() => {
        console.log(user.id)
    })

    return <main>{user.id}</main>;
  }
  
  export default AccountDetailsPage;
  