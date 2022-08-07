package com.example.coffeemachine

data class Receipe(
    val water : Int,
    val milk : Int,
    val coffee : Int,
    val pure : Int
)

fun main() {
    val menu = listOf(
        "Выберите пункт меню для взаимодействия:" + "\n",
        "0. Выключить кофемашину." + "\n",
        "1. Включить кофемашину." + "\n",
        "2. Приготовить капучино." + "\n",
        "3. Приготовить эспрессо." + "\n",
        "4. Приготовить латте." + "\n",
        "5. Приготовить кофе по своему рецепту." + "\n",
        "6. Добавить воды." + "\n",
        "7. Добавить кофе." + "\n",
        "8. Добавить молока." + "\n",
        "9. Помыть кофемашину." + "\n",
        "Меню - отображает меню." + "\n",
        "Капучино - отображает рецепт капучино." + "\n",
        "Эспрессо - отображает рецепт эспрессо." + "\n",
        "Латте - отображает рецепт латте."
    )
    println(menu)

    val recepies = mapOf(
        "Espresso" to Receipe(10, 0,10,10),
        "Latte" to Receipe(10, 20,10,10),
        "Cappuccino" to Receipe(10, 20,10,10),
    )

    var currentWater = 100
    val maxWater = 100
    var currentCoffee = 100
    val maxCoffee = 100
    var currentMilk = 100
    val maxMilk = 100
    var currentPure = 100
    val maxPure = 100
    var enabled = false

    while (true) {
        var input = readln()
        when (input) {
            "меню" -> {
                println(menu)
            }
            "капучино" -> {
                println("Количество воды - 20, количество кофе - 10, количество молока - 10.")
            }
            "эспрессо" -> {
                println("Количество воды - 10, количество кофе - 10, количество молока - 0.")
            }
            "латте" -> {
                println("Количество воды - 10, количество кофе - 10, количество молока - 20.")
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
                    val cups = input.toInt()
                    val currentRecipe = recepies["Cappuccino"]
                    currentRecipe?.run {

                        if (cups <= 5) {

                            if (currentWater >= water * cups &&
                                currentCoffee >= coffee * cups &&
                                currentMilk >= milk * cups &&
                                currentPure >= pure * cups) {

                                currentWater -= water * cups
                                currentCoffee -= coffee * cups
                                currentMilk -= milk * cups
                                currentPure -= pure * cups
                                println(
                                    "Ваш капучино готов.\n" +
                                            " Оставшееся количество воды:$currentWater," +
                                            " Оставшееся количество кофе:$currentCoffee," +
                                            "Оставшееся количество молока:$currentMilk"
                                )
                                println(menu)

                            } else if (currentWater <= water) {
                                println("Необходимо добавить воды.")
                            } else if (currentCoffee <= coffee) {
                                println("Необходимо добавить кофе.")
                            } else if (currentMilk <= milk) {
                                println("Необходимо добавить молока.")
                            } else if (currentPure <= pure) {
                                println("Необходимо помыть кофемашину.")
                            }
                        } else {
                            println("Максимальное количество кружек 5.")
                            println(menu)
                        }
                    }
                } else {
                    println("Необходимо включить кофемашину.")
                }
            }
            "3" -> {
                if (enabled) {
                    println("Введите количество кружек:")
                    input = readln()
                    val parsed = input.toIntOrNull() ?: 1
                    if (parsed <= 10) {

                        val needWater = 10 * parsed
                        val needCoffee = 10 * parsed
                        val needPure = 10 * parsed

                        if (currentWater >= needWater && currentCoffee >= needCoffee && currentPure  >= needPure) {
                            currentWater -= 10 * parsed
                            currentCoffee -= 10 * parsed
                            currentPure -= 10 * parsed
                            println(
                                "Ваш эспрессо готов.\n" +
                                        " Оставшееся количество воды:$currentWater," +
                                        " Оставшееся количество кофе:$currentCoffee," +
                                        "Оставшееся количество молока:$currentMilk"
                            )
                            println(menu)
                        } else if (currentWater <= 10) {
                            println("Необходимо добавить воды.")
                        } else if (currentCoffee <= 10) {
                            println("Необходимо добавить кофе.")
                        } else if (currentPure <= 10) {
                            println("Необходимо помыть кофемашину.")
                        }
                    } else {
                        println("Максимальное количество кружек 10.")
                        println(menu)
                    }
                } else {
                    println("Необходимо включить кофемашину.")
                }
            }
            "4" -> {
                if (enabled) {
                    println("Введите количество кружек:")
                    input = readln()
                    val parsed = input.toInt()
                    if (parsed <= 5) {
                        if (currentWater * parsed >= 10 && currentCoffee * parsed >= 10 && currentMilk * parsed >= 20 && currentPure * parsed >= 10) {
                            currentWater -= 10 * parsed
                            currentCoffee -= 10 * parsed
                            currentMilk -= 20 * parsed
                            currentPure -= 10 * parsed
                            println(
                                "Ваш латте готов.\n" +
                                        " Оставшееся количество воды:$currentWater," +
                                        " Оставшееся количество кофе:$currentCoffee," +
                                        "Оставшееся количество молока:$currentMilk"
                            )
                            println(menu)
                        } else if (currentWater <= 10) {
                            println("Необходимо добавить воды.")
                        } else if (currentCoffee <= 10) {
                            println("Необходимо добавить кофе.")
                        } else if (currentMilk <= 20) {
                            println("Необходимо добавить молока.")
                        } else if (currentPure <= 10) {
                            println("Необходимо помыть кофемашину.")
                        }
                    } else {
                        println("Максимальное количество кружек 5.")
                        println(menu)
                    }
                } else {
                    println("Необходимо включить кофемашину.")
                }
            }
            "5" -> {
                if (enabled) {
                    println("Введите количество кружек:")
                    input = readln()
                    val parsed = input.toInt()
                    println("Введите количество воды:")
                    val waters = readLine()!!.toInt()
                    println("Введите количество кофе:")
                    val coffees = readLine()!!.toInt()
                    println("Введите количество молока:")
                    val milks = readLine()!!.toInt()
                    if (parsed <= 5) {
                        if (waters * parsed >= 1 && coffees * parsed >= 1 && milks * parsed >= 2 && currentPure * parsed >= 10) {
                            currentWater -= waters * parsed
                            currentCoffee -= coffees * parsed
                            currentMilk -= milks * parsed
                            currentPure -= 10 * parsed
                            println(
                                "Ваш кофе готов.\n" +
                                        " Оставшееся количество воды:$currentWater," +
                                        " Оставшееся количество кофе:$currentCoffee," +
                                        "Оставшееся количество молока:$currentMilk"
                            )
                            println(menu)
                        } else if (currentWater <= 10) {
                            println("Необходимо добавить воды.")
                        } else if (currentCoffee <= 10) {
                            println("Необходимо добавить кофе.")
                        } else if (currentMilk <= 20) {
                            println("Необходимо добавить молока.")
                        } else if (currentPure <= 10) {
                            println("Необходимо помыть кофемашину.")
                        }
                    } else {
                        println("Максимальное количество кружек 5.")
                        println(menu)
                    }
                } else {
                    println("Необходимо включить кофемашину.")
                }
            }

            "6" -> {
                currentWater = maxWater
                println("Количество воды возобновлено.")

            }
            "7" -> {
                currentCoffee = maxCoffee
                println("Количество кофе возобновлено.")

            }
            "8" -> {
                currentMilk = maxMilk
                println("Количество молока возобновлено.")

            }
            "9" -> {

                currentPure = maxPure
                println("Кофемашина помыта.")

            }
            else -> {
                println("Неизвестная команда")
                continue
            }
        }
    }
}
