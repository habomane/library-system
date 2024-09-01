import librarypng from '../assets/jpg/library.jpg';
import receivingbook from '../assets/jpg/choosingbook.jpg';
import returnbook from '../assets/jpg/returnbook.jpg'

function HomePage()
{
    return (
        <main>
            <section className="home-bg flex px-20 items-center">
                <h1 className="text-white text-7xl font-extrabold md:w-1/2 tracking-wide text-left">
                 Connect, Share, and Discover New Reads
                </h1>
            </section>

            <section className="flex justify-center items-center">
                <p className="text-lg px-20 py-20 text-center">
                Our mission is to ignite a passion for reading and writing by sharing books and knowledge with the community. We believe in the transformative power of stories and ideas, and we are dedicated to creating a space where individuals can discover new perspectives, exchange insights, and inspire one another to embark on their own creative journeys. Through our efforts, we aim to cultivate a lifelong love of literature and empower others to share their voices with the world.
                </p>
            </section>

            <section className="flex flex-col gap-y-5 bg-[#0cb03b18]">
                <h2 className="font-semibold text-center text-2xl pt-5">How it Works</h2>

                <div className="flex flex-col md:flex-row justify-around px-10 py-4 items-center gap-y-5">
                    <div className="md:w-1/2 text-center md:text-left">
                    <p className="text-lg"><span className="text-white font-semibold bg-green-700 py-1 px-3 rounded-full mr-3">1</span>Step One</p>
                    <p className="text-lg mt-3">Users browse through the existing library to identify whether any of the books are of interest. Users are also able to post books available for other community members to use.</p>
                    </div>
                    <img 
                    src={librarypng}
                    className="img fit-content h-[44vh] py-3"/>
                </div>

                <div className="flex flex-col-reverse md:flex-row justify-around px-10 py-8 items-center bg-white gap-y-5">
                <img 
                    src={receivingbook}
                    className="img fit-content h-[44vh] py-3"/>
                    <div className="md:w-1/2 text-center md:text-left">
                    <p className="text-lg"><span className="text-white font-semibold bg-green-700 py-1 px-3 rounded-full mr-3">2</span>Step Two</p>
                    <p className="text-lg mt-3">Once users have identified a book of interest, users can submit a request to the original poster. This will alert the book owner of your book interest. From there, users can coordinate as needed.</p>
                    </div>
                </div>


                <div className="flex flex-col md:flex-row justify-around px-10 py-8 items-center gap-y-5">
                    <div className="md:w-1/2 text-center md:text-left">
                    <p className="text-lg"><span className="text-white font-semibold bg-green-700 py-1 px-3 rounded-full mr-3">3</span>Step Three</p>
                    <p className="text-lg mt-3">Once users have received the book, it is theirs to enjoy for the allocated time. All material on the community library should be returned if that was specified by the original poster. Happy reading!</p>
                    <button className="rounded-lg px-4 mt-8 py-2 font-medium bg-green-700 hover:bg-green-900 text-white duration-300">
                Discover
              </button>
                    </div>
                    <img 
                    src={returnbook}
                    className="img fit-content h-[44vh] py-3"/>
                </div>

            </section>
        </main>
    )
}

export default HomePage;