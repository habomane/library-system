import { Book } from "../models/";
import { BookGenre } from "../types";
export const mockBook1 = new Book(
    "To Kill a Mockingbird",
    "Harper Lee",
  BookGenre.FICTION,
    "https://example.com/tokillamockingbird.jpg",
    true,
    "12345",
    "A novel about the serious issues of rape and racial inequality.",
    "harperfan123"
);

export const mockBook2 = new Book(
    "1984",
    "George Orwell",
  BookGenre.THRILLER, 
    "https://example.com/1984.jpg",
    true,
    "23456",
    "A dystopian novel set in a totalitarian society ruled by Big Brother.",
    "orwellian89"
);

export const mockBook3 = new Book(
    "Pride and Prejudice",
    "Jane Austen",
  BookGenre.ROMANCE, 
    "https://example.com/prideandprejudice.jpg",
    false,
    "34567",
    "A romantic novel that charts the emotional development of the protagonist Elizabeth Bennet.",
    "austenlover"
);

export const mockBook4 = new Book(
    "The Great Gatsby",
    "F. Scott Fitzgerald",
  BookGenre.DYSTOPIAN,
    "https://example.com/thegreatgatsby.jpg",
    true,
    "45678",
    "A novel about the American dream and the Roaring Twenties.",
    "gatsbyfanatic"
);

export const mockBook5 = new Book(
    "Moby-Dick",
    "Herman Melville",
  BookGenre.ADVENTURE,
    "https://example.com/mobydick.jpg",
    true,
    "56789",
    "The narrative of Captain Ahab's obsessive quest to kill the white whale, Moby-Dick.",
    "whalewatcher"
);

export const mockBook6 = new Book(
    "War and Peace",
    "Leo Tolstoy",
  BookGenre.HISTORICAL_FICTION,
    "https://example.com/warandpeace.jpg",
    false,
    "67890",
    "A historical novel that intertwines the lives of private and public individuals during the time of the Napoleonic wars.",
    "tolstoy_fan"
);

export const mockBook7 = new Book(
    "The Catcher in the Rye",
    "J.D. Salinger",
  BookGenre.FICTION,
    "https://example.com/thecatcherintherye.jpg",
    true,
    "78901",
    "A novel about the challenges of teenage angst and alienation.",
    "salingerfan"
);

export const mockBook8 = new Book(
    "The Hobbit",
    "J.R.R. Tolkien",
  BookGenre.FICTION,
    "https://example.com/thehobbit.jpg",
    true,
    "89012",
    "A fantasy novel that follows the quest of Bilbo Baggins.",
    "middleearthlover"
);

export const mockBook9 = new Book(
    "Fahrenheit 451",
    "Ray Bradbury",
  BookGenre.HISTORICAL_FICTION,
    "https://example.com/fahrenheit451.jpg",
    true,
    "90123",
    "A dystopian novel about a future society wheremockBooks are banned and burned.",
    "bradburysburners"
);

export const mockBook10 = new Book(
    "Jane Eyre",
    "Charlotte Brontë",
  BookGenre.BIOGRAPHY,
    "https://example.com/janeeyre.jpg",
    false,
    "01234",
    "A novel that follows the experiences of the titular character, including her growth into adulthood and her love for Mr. Rochester.",
    "charlottefan"
);

export const mockBook11 = new Book(
    "Crime and Punishment",
    "Fyodor Dostoevsky",
  BookGenre.THRILLER,
    "https://example.com/crimeandpunishment.jpg",
    true,
    "12345",
    "A psychological novel about the moral dilemmas of a poor ex-student who plots to murder a pawnbroker.",
    "dostoevsky_fan"
);

export const mockBook12 = new Book(
    "The Lord of the Rings",
    "J.R.R. Tolkien",
  BookGenre.FANTASY,
    "https://example.com/thelordoftherings.jpg",
    true,
    "23456",
    "An epic high-fantasy novel that follows the quest to destroy the One Ring.",
    "ringbearer"
);

export const mockBook13 = new Book(
    "The Catcher in the Rye",
    "J.D. Salinger",
  BookGenre.FICTION,
    "https://example.com/thecatcherintherye.jpg",
    true,
    "34567",
    "A novel about the challenges of teenage angst and alienation.",
    "holden_lover"
);

export const mockBook14 = new Book(
    "Brave New World",
    "Aldous Huxley",
  BookGenre.DYSTOPIAN,
    "https://example.com/bravenewworld.jpg",
    true,
    "45678",
    "A dystopian novel that explores a futuristic society driven by technology and consumerism.",
    "huxleyfan"
);

export const mockBook15 = new Book(
    "Wuthering Heights",
    "Emily Brontë",
  BookGenre.HISTORICAL_FICTION,
    "https://example.com/wutheringheights.jpg",
    true,
    "56789",
    "A novel about the intense and tragic love between Catherine Earnshaw and Heathcliff.",
    "bronte_sister"
);

export const mockBook16 = new Book(
    "The Odyssey",
    "Homer",
  BookGenre.FICTION,
    "https://example.com/theodyssey.jpg",
    true,
    "67890",
    "An epic poem that follows the adventures of Odysseus on his journey home from the Trojan War.",
    "ancientadventures"
);

export const mockBook17 = new Book(
    "The Brothers Karamazov",
    "Fyodor Dostoevsky",
  BookGenre.HORROR,
    "https://example.com/thebrotherskaramazov.jpg",
    true,
    "78901",
    "A philosophical novel that delves into the complex issues of faith, doubt, and morality.",
    "russianlitlover"
);

export const mockBook18 = new Book(
    "Anna Karenina",
    "Leo Tolstoy",
  BookGenre.ROMANCE,
    "https://example.com/annakarenina.jpg",
    false,
    "89012",
    "A novel that explores the life of the titular character and her tragic affair with Count Vronsky.",
    "annalover"
);

export const mockBook19 = new Book(
    "Don Quixote",
    "Miguel de Cervantes",
  BookGenre.THRILLER,
    "https://example.com/donquixote.jpg",
    true,
    "90123",
    "A novel that follows the adventures of a nobleman who believes he is a knight and his squire, Sancho Panza.",
    "windmillwarrior"
);

export const mockBook20 = new Book(
    "The Divine Comedy",
    "Dante Alighieri",
  BookGenre.CRIME,
    "https://example.com/thedivinecomedy.jpg",
    true,
    "01234",
    "An epic poem that describes the journey of the poet through Hell, Purgatory, and Paradise.",
    "dantesinferno"
);


export const allBooksMock = [mockBook1,mockBook2,mockBook3,mockBook4,mockBook5,mockBook6, 
   mockBook7,mockBook8,mockBook9,mockBook10,
   mockBook11,mockBook12,mockBook13,mockBook14,mockBook15,mockBook16, 
   mockBook17,mockBook18,mockBook19,mockBook20
];
