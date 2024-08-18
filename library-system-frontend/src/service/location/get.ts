

export async function getLocation(zipcode: string)
{
    const API_KEY = import.meta.env.VITE_GEOCODE_API_KEY;
    const data = await fetch(`https://maps.googleapis.com/maps/api/geocode/json?address=${zipcode}&key=${API_KEY}`);
    const response = await data.json();
    if(response.status == "OK") { return response.results[0].formatted_address}
    return "No Location Provided"
}