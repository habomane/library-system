import { Link } from "react-router-dom";

function LoginPage()
{
    return (
    <main className="flex justify-center items-center w-full h-full">
        <div className="w-96 rounded-lg shadow-lg p-5 bg-green-700 text-white">
  <h2 className="text-2xl font-bold pb-5 text-center">Log In</h2>
  <label  className="block mb-2 text-sm font-medium">Private Key</label>
      <input
        type="text"
        id="name"
        className="bg-gray-100 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-2 focus:ring-blue-500 focus:border-blue-500 w-full py-2.5 px-4"
        placeholder="Andrew Jackson"
        required
        value=""
      />
    <div className="flex flex-col items-center gap-y-5 justify-between mb-4 mt-5">
      <button
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