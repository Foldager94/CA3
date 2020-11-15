import React from "react";

const Home = () => {
  return (
    <>
      <p>
        Der er blevet tilføjet en signup page, der kan tilføje en ny bruger i
        databasen. Brugeren der bliver tilføjet vil have rolen user
      </p>
      <p>
        Når der bliver logget ind som user, kan man gå til userSite hvor der vil
        blive lavet et fetch kald til et endpoint i backenden, hvor der bliver
        hentet et billede og en fact om koalaer, der bliver hentet fra en anden
        server. Det er kun muligt at hentet dette med rolen user
      </p>
      <p>
        Hvis brugerten logger ind som admin, vil brugeren kunne gå til adminsite
        hvor der kan blive hentet en liste over alle users i systemet, samt
        deres favorit bloms og stjernetegn. Denne liste er kun muligt at hente
        med rolen admin
      </p>
    </>
  );
};

export default Home;
