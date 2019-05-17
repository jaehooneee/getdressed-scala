**Description:**

This is a command-line scala application written based on attached coding challenge description.

    RewardsNetwork-DeveloperCodingChallenge.pdf

**Assumptions**

* Input:
    * Must start with "HOT" or "COLD"
    * Comma separated list of numeric commands
        * Description had spaces after "," so application is written to consume each numeric command as separate argument: "#,"

**Execute Example:**

From ./GetDressedApp directory

    mvn package
    scala -cp target/classes GetDressedApp HOT 8, 6, 4, 2, 1, 7
    scala -cp target/classes GetDressedApp COLD 8, 6, 3, 4, 2, 5, 1, 7
   