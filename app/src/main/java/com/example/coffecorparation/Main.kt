package com.example.coffecorparation

fun main() {
    var menu = listOf(
        "Выберите пункт меню для взаимодействия:" + "\n",
        "0. Выключить кофемашину." + "\n",
        "1. Включить кофемашину." + "\n",
        "2. Приготовить капучино." + "\n",
        "3. Приготовить эспрессо." + "\n",
        "4. Приготовить латте." + "\n",
        "5. Добавить воды." + "\n",
        "6. Добавить кофе." + "\n",
        "7. Добавить молока." + "\n",
        "8. Помыть кофемашину." + "\n",
        "show menu - отображает меню."
    )
    println(menu)

    var water: Int = 100
    val maxWater = 100
    var coffee: Int = 100
    val maxCoffee = 100
    var milk: Int = 100
    val maxMilk = 100
    var pure: Int = 100
    val maxPure = 100
    var enabled = false
    var cup: UInt


    while (true) {

        var input = readln()

        when (input) {
            "show menu" -> {
                println(menu)
            }
            "0" -> {
                if (!enabled) {
                    println("Кофемашина уже выключена")
                } else {
                    enabled = false
                    println("Кофемашина выключена")
                }
            }
            "1" -> {
                if (enabled) {
                    println("Кофемашина уже включена")
                } else {
                    enabled = true
                    println("Кофемашина включена")
                }

            }
            "2" -> {
                if (enabled) {
                    println("Введите количество кружек:")
                    input = readln()
                    val parsed = input.toInt()
                    if (parsed <= 10) {

                        if (water * parsed >= 20 && coffee * parsed >= 10 && milk * parsed >= 10 && pure * parsed >= 10) {
                            water -= 20 * parsed
                            coffee -= 10 * parsed
                            milk -= 10 * parsed
                            pure -= 10 * parsed
                            println(
                                "Ваш капучино готов.\n" +
                                        " Оставшееся количество воды:$water," +
                                        " Оставшееся количество кофе:$coffee," +
                                        "Оставшееся количество молока:$milk"
                            )

                        } else if (water <= 20) {
                            println("Необходимо добавить воды.")
                        } else if (coffee <= 10) {
                            println("Необходимо добавить кофе.")
                        } else if (milk <= 10) {
                            println("Необходимо добавить молока.")
                        } else if (pure <= 10) {
                            println("Необходимо помыть кофемашину.")
                        } else {
                            println("Необходимо включить кофемашину.")
                        }
                    }
                }
            }
            "3" -> {
                if (enabled == true && water >= 10 && coffee >= 10 && pure >= 10) {
                    water -= 10
                    coffee -= 10
                    milk -= 0
                    pure -= 10
                    println(
                        "Ваш эспрессо готов.\n" +
                                " Оставшееся количество воды:$water," +
                                " Оставшееся количество кофе:$coffee," +
                                "Оставшееся количество молока:$milk"
                    )
                } else if (water <= 10) {
                    println("Необходимо добавить воды.")
                } else if (coffee <= 10) {
                    println("Необходимо добавить кофе.")
                } else if (pure <= 10) {
                    println("Необходимо помыть кофемашину.")
                } else {
                    println("Необходимо включить кофемашину.")
                }
            }
            "4" -> {
                if (enabled == true && water >= 10 && coffee >= 10 && milk >= 20 && pure >= 10) {
                    water -= 10
                    coffee -= 10
                    milk -= 20
                    pure -= 10
                    println(
                        "Ваш латте готов.\n" +
                                " Оставшееся количество воды:$water," +
                                " Оставшееся количество кофе:$coffee," +
                                "Оставшееся количество молока:$milk"
                    )

                } else if (water <= 10) {
                    println("Необходимо добавить воды.")
                } else if (coffee <= 10) {
                    println("Необходимо добавить кофе.")
                } else if (milk <= 20) {
                    println("Необходимо добавить молока.")
                } else if (pure <= 10) {
                    println("Необходимо помыть кофемашину.")
                } else {
                    println("Необходимо включить кофемашину.")
                }
            }
            "5" -> {
                water = maxWater
                println("Количество воды возобновлено.")

            }
            "6" -> {
                coffee = maxCoffee
                println("Количество кофе возобновлено.")

            }
            "7" -> {
                milk = maxMilk
                println("Количество молока возобновлено.")

            }
            "8" -> {

                pure = maxPure
                println("Кофемашина помыта.")

            }
            else -> {
                println("Неизвестная команда")
                continue
            }
        }
    }
}


