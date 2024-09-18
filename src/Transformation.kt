import java.util.*

class Transformation {
    private val people: List<Person> = listOf(
        Person(firstName = "John", lastName = "Doe", nationality = "American", age = 30),
        Person(firstName = "Jane", lastName = "Smith", nationality = "Indian", age = 25),
        Person(firstName = "Carlos", lastName = "Garcia", nationality = "Spanish", age = 40),
        Person(firstName = "Aiko", lastName = "Tanaka", nationality = "Japanese", age = 35),
        Person(firstName = "Maria", lastName = "Rossi", nationality = "Italian", age = 28),
        Person(firstName = "Fatima", lastName = "Hassan", nationality = "Egyptian", age = 33),
        Person(firstName = "Liu", lastName = "Wei", nationality = "Chinese", age = 22),
        Person(firstName = "Olga", lastName = "Ivanova", nationality = "Russian", age = 29),
        Person(firstName = "Ahmed", lastName = "Khan", nationality = "Pakistani", age = 45),
        Person(firstName = "Emily", lastName = "Brown", nationality = "Canadian", age = 32)
    )

    fun run() {
        /*map()
        zip()
        associate()
        flatten()*/
        stringRepresentation()
    }

    /**
     * joinToString() -> Builds a single String from the collection elements based on the provided arguments.
     * joinTo() -> Appends the result to the given Appendable object
     */
    private fun stringRepresentation() {
        val numbers: List<String> = listOf("one", "two", "three", "four")
        println(numbers) // op -> [one, two, three, four]
        println(numbers.joinToString()) // op -> one, two, three, four

        val listString: StringBuffer = StringBuffer("The list of numbers: ")
        numbers.joinTo(listString)
        println(listString) // op -> one, two, three, four
    }

    private fun flatten() {
        val numberSets: List<Set<Int>> = listOf(setOf(1, 2, 3), setOf(4, 5, 6), setOf(1, 2))
        val flatten: List<Int> = numberSets.flatten()
        println(flatten) // op -> [1, 2, 3, 4, 5, 6, 1, 2]
    }

    private fun associate() {
        val associatedList: Map<String, Person> = people.associateBy { it -> it.firstName + it.lastName + it.age }

        associatedList.forEach { (first, second) -> println("$first -> $second") }
        /*  output ->
            JohnDoe30 -> Person(firstName=John, lastName=Doe, nationality=American, age=30)
            JaneSmith25 -> Person(firstName=Jane, lastName=Smith, nationality=Indian, age=25)
            CarlosGarcia40 -> Person(firstName=Carlos, lastName=Garcia, nationality=Spanish, age=40)
            AikoTanaka35 -> Person(firstName=Aiko, lastName=Tanaka, nationality=Japanese, age=35)
            MariaRossi28 -> Person(firstName=Maria, lastName=Rossi, nationality=Italian, age=28)
            FatimaHassan33 -> Person(firstName=Fatima, lastName=Hassan, nationality=Egyptian, age=33)
            LiuWei22 -> Person(firstName=Liu, lastName=Wei, nationality=Chinese, age=22)
            OlgaIvanova29 -> Person(firstName=Olga, lastName=Ivanova, nationality=Russian, age=29)
            AhmedKhan45 -> Person(firstName=Ahmed, lastName=Khan, nationality=Pakistani, age=45)
            EmilyBrown32 -> Person(firstName=Emily, lastName=Brown, nationality=Canadian, age=32)
        */
    }

    private fun zip() {
        val firstNames = listOf("John", "Jane", "Carlos", "Aiko", "Maria")
        val lastNames = listOf("Doe", "Smith", "Garcia", "Tanaka", "Rossi")

        val zip: List<Pair<String, String>> = firstNames.zip(lastNames)
        println(zip) // output -> [(John, Doe), (Jane, Smith), (Carlos, Garcia), (Aiko, Tanaka), (Maria, Rossi)]

        val unzip: Pair<List<String>, List<String>> = zip.unzip()
        println("first = ${unzip.first}") // output -> [John, Jane, Carlos, Aiko, Maria]
        println("second = ${unzip.second}") // output -> [Doe, Smith, Garcia, Tanaka, Rossi]

        (firstNames.plus(lastNames)).zipWithNext { a: String, b: String ->
            print("${a}_${b} ") // output -> John_Jane Jane_Carlos Carlos_Aiko Aiko_Maria Maria_Doe Doe_Smith Smith_Garcia Garcia_Tanaka Tanaka_Rossi
        }
    }

    private fun map() {
        val mapList = people.map {
            it.firstName + "_" + it.lastName
        }
        print(mapList) // output -> [John_Doe, Jane_Smith, Carlos_Garcia, Aiko_Tanaka, Maria_Rossi, Fatima_Hassan, Liu_Wei, Olga_Ivanova, Ahmed_Khan, Emily_Brown]

        /* map with index */
        val mapWithIndexList: List<Unit> = people.mapIndexed { s, t ->
            print("$s ${t.firstName} ") // output -> 0 John 1 Jane 2 Carlos 3 Aiko 4 Maria 5 Fatima 6 Liu 7 Olga 8 Ahmed 9 Emily
        }

        /* map not null */
        val mapNotNull: List<String?> = people.map { if (it.nationality !== "Indian") it.firstName else null }
        println(mapNotNull) // output -> [John, null, Carlos, Aiko, Maria, Fatima, Liu, Olga, Ahmed, Emily]

        val cityStates = buildMap<String, String> {
            put("Bangalore", "Karnataka")
            put("Mumbai", "Maharashtra")
            put("Panji", "Goa")
            put("Hydrabad", "Telengana")
            put("Chennai", "tamil Nadu")
        }

        val cityStateList = cityStates.map { entry: Map.Entry<String, String> ->
            "${entry.key.uppercase(Locale.getDefault())}_${entry.value}"
        }
        println(cityStateList) // output -> [BANGALORE_Karnataka, MUMBAI_Maharashtra, PANJI_Goa, HYDRABAD_Telengana, CHENNAI_tamil Nadu]
    }
}