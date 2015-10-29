package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        if (year != other.year) {
            return year - other.year
        } else if (month != other.month) {
            return month - other.month
        } else if (dayOfMonth != other.dayOfMonth) {
            return dayOfMonth - other.dayOfMonth
        }

        return 0
    }
}

fun MyDate.rangeTo(end: MyDate): DateRange {
    return DateRange(this, end)
}

fun MyDate.plus(vararg timeIntervals: TimeInterval): MyDate {
    return timeIntervals.fold(this, {date, timeInterval -> date.addTimeIntervals(timeInterval, 1)})
}

fun TimeInterval.times(num: Int): Array<TimeInterval> {
    return Array(num, {this})
}

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(public override val start: MyDate, public override val end: MyDate) : Iterable<MyDate>, Range<MyDate> {
    override fun contains(item: MyDate): Boolean {
        return start <= item && item <= end
    }

    override fun iterator(): Iterator<MyDate> {
        return object : Iterator<MyDate> {
            private var current = start

            override fun hasNext(): Boolean {
                return current <= end
            }

            override fun next(): MyDate {
                val iDate = current
                current = current.nextDay()

                return iDate
            }
        }
    }
}
