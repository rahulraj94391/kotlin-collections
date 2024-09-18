import java.util.*

class Transformation {
    fun run() {
        map()
//        zip()
    }

    private fun zip() {
        val firstNames = listOf("John", "Jane", "Carlos", "Aiko", "Maria")
        val lastNames = listOf("Doe", "Smith", "Garcia", "Tanaka", "Rossi")

        val zip = firstNames.zip(lastNames)
        // println(zip)

        (firstNames.plus(lastNames)).zipWithNext { a, b ->
            println("${a}_${b}")
        }
    }

    private fun map() {
        val people = listOf(
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
        /* map */
        val mapList = people.map {
            it.firstName + "_" + it.lastName
        }
        print(mapList) // output -> [John_Doe, Jane_Smith, Carlos_Garcia, Aiko_Tanaka, Maria_Rossi, Fatima_Hassan, Liu_Wei, Olga_Ivanova, Ahmed_Khan, Emily_Brown]

        /* map with index */
        val mapWithIndexList = people.mapIndexed { s, t ->
            print("$s ${t.firstName} ") // output -> 0 John 1 Jane 2 Carlos 3 Aiko 4 Maria 5 Fatima 6 Liu 7 Olga 8 Ahmed 9 Emily
        }

        /* map not null */
        val mapNotNull = people.map { if (it.nationality !== "Indian") it.firstName else null }
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