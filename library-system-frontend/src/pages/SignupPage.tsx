import { Link } from "react-router-dom";

function SignUpPage()
{
    return (
    <main className="flex justify-center items-center w-full h-full">
        <div className="w-96 rounded-lg shadow-lg p-5 bg-green-700 text-white">
  <h2 className="text-2xl font-bold pb-5 text-center">Sign Up</h2>
    <div className="flex flex-col items-center gap-y-5 justify-between mb-4">
      <button
        type="submit"
        className="text-white bg-black hover:bg-white hover:text-black focus:ring-2 focus:ring-blue-300 font-medium rounded-lg text-sm py-2.5 px-5 w-full sm:w-auto"
      >
        Register
      </button>
      <div className="flex items-center text-sm">
        <p>Already have an account?</p>
        <Link to="/login"><p className="underline cursor-pointer ml-1">Sign in</p></Link>
      </div>
    </div>

</div>

    </main>)
}


export default SignUpPage;