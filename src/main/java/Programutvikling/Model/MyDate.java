package Programutvikling.Model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyDate extends Calendar{
    private int day;
    private int month;
    private int year;
    private String monthInText;
    private String[] months =
        {"januar","februar","mars","april","mai","juni","juli","august","september","oktober","november","desember"};

    //Gettere og settere for day, month og year
    public int getDay() { return day; }

    public void setDay(int day) { this.day = day; }

    public int getMonth() { return month; }

    public void setMonth(int month) { this.month = month; }

    public void setMonths(String[] months) { this.months = months; }

    public int getYear() { return year; }

    public void setYear(int year) { this.year = year; }

    //Metode for å gjøre om måned(month) i tall til måned i tekst
    public void getMonthInText(int month) { monthInText = months[month-1]; }

    //Konstruktør som blir brukt med gitte parametre
    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    //Default konstruktør som bli brukt hvis ingen paremetre er gitt
    public MyDate() {
        Calendar currentDate = Calendar.getInstance(); //Hent dagens dato
        java.util.Date n = currentDate.getTime();
        SimpleDateFormat formatYear = new SimpleDateFormat("yyyy");
        this.year = Integer.parseInt(formatYear.format(n));
        SimpleDateFormat formatMonth = new SimpleDateFormat("MM");
        this.month = Integer.parseInt(formatMonth.format(n));
        SimpleDateFormat formatDay = new SimpleDateFormat("dd");
        this.day = Integer.parseInt(formatDay.format(n));
    }

    /**
     * Converts the current calendar field values in {@link #fields fields[]}
     * to the millisecond time value
     * {@link #time}.
     *
     * @see #complete()
     * @see #computeFields()
     */
    @Override
    protected void computeTime() {

    }

    /**
     * Converts the current millisecond time value {@link #time}
     * to calendar field values in {@link #fields fields[]}.
     * This allows you to sync up the calendar field values with
     * a new time that is set for the calendar.  The time is <em>not</em>
     * recomputed first; to recompute the time, then the fields, call the
     * {@link #complete()} method.
     *
     * @see #computeTime()
     */
    @Override
    protected void computeFields() {

    }

    /**
     * Adds or subtracts the specified amount of time to the given calendar field,
     * based on the calendar's rules. For example, to subtract 5 days from
     * the current time of the calendar, you can achieve it by calling:
     * <p><code>add(Calendar.DAY_OF_MONTH, -5)</code>.
     *
     * @param field  the calendar field.
     * @param amount the amount of date or time to be added to the field.
     * @see #roll(int, int)
     * @see #set(int, int)
     */
    @Override
    public void add(int field, int amount) {

    }

    /**
     * Adds or subtracts (up/down) a single unit of time on the given time
     * field without changing larger fields. For example, to roll the current
     * date up by one day, you can achieve it by calling:
     * <p>roll(Calendar.DATE, true).
     * When rolling on the year or Calendar.YEAR field, it will roll the year
     * value in the range between 1 and the value returned by calling
     * <code>getMaximum(Calendar.YEAR)</code>.
     * When rolling on the month or Calendar.MONTH field, other fields like
     * date might conflict and, need to be changed. For instance,
     * rolling the month on the date 01/31/96 will result in 02/29/96.
     * When rolling on the hour-in-day or Calendar.HOUR_OF_DAY field, it will
     * roll the hour value in the range between 0 and 23, which is zero-based.
     *
     * @param field the time field.
     * @param up    indicates if the value of the specified time field is to be
     *              rolled up or rolled down. Use true if rolling up, false otherwise.
     * @see Calendar#add(int, int)
     * @see Calendar#set(int, int)
     */
    @Override
    public void roll(int field, boolean up) {

    }

    /**
     * Returns the minimum value for the given calendar field of this
     * <code>Calendar</code> instance. The minimum value is defined as
     * the smallest value returned by the {@link #get(int) get} method
     * for any possible time value.  The minimum value depends on
     * calendar system specific parameters of the instance.
     *
     * @param field the calendar field.
     * @return the minimum value for the given calendar field.
     * @see #getMaximum(int)
     * @see #getGreatestMinimum(int)
     * @see #getLeastMaximum(int)
     * @see #getActualMinimum(int)
     * @see #getActualMaximum(int)
     */
    @Override
    public int getMinimum(int field) {
        return 0;
    }

    /**
     * Returns the maximum value for the given calendar field of this
     * <code>Calendar</code> instance. The maximum value is defined as
     * the largest value returned by the {@link #get(int) get} method
     * for any possible time value. The maximum value depends on
     * calendar system specific parameters of the instance.
     *
     * @param field the calendar field.
     * @return the maximum value for the given calendar field.
     * @see #getMinimum(int)
     * @see #getGreatestMinimum(int)
     * @see #getLeastMaximum(int)
     * @see #getActualMinimum(int)
     * @see #getActualMaximum(int)
     */
    @Override
    public int getMaximum(int field) {
        return 0;
    }

    /**
     * Returns the highest minimum value for the given calendar field
     * of this <code>Calendar</code> instance. The highest minimum
     * value is defined as the largest value returned by {@link
     * #getActualMinimum(int)} for any possible time value. The
     * greatest minimum value depends on calendar system specific
     * parameters of the instance.
     *
     * @param field the calendar field.
     * @return the highest minimum value for the given calendar field.
     * @see #getMinimum(int)
     * @see #getMaximum(int)
     * @see #getLeastMaximum(int)
     * @see #getActualMinimum(int)
     * @see #getActualMaximum(int)
     */
    @Override
    public int getGreatestMinimum(int field) {
        return 0;
    }

    /**
     * Returns the lowest maximum value for the given calendar field
     * of this <code>Calendar</code> instance. The lowest maximum
     * value is defined as the smallest value returned by {@link
     * #getActualMaximum(int)} for any possible time value. The least
     * maximum value depends on calendar system specific parameters of
     * the instance. For example, a <code>Calendar</code> for the
     * Gregorian calendar system returns 28 for the
     * <code>DAY_OF_MONTH</code> field, because the 28th is the last
     * day of the shortest month of this calendar, February in a
     * common year.
     *
     * @param field the calendar field.
     * @return the lowest maximum value for the given calendar field.
     * @see #getMinimum(int)
     * @see #getMaximum(int)
     * @see #getGreatestMinimum(int)
     * @see #getActualMinimum(int)
     * @see #getActualMaximum(int)
     */
    @Override
    public int getLeastMaximum(int field) {
        return 0;
    }

    @Override
    public String toString() {
        return day + ";" + month + ";" + year;
    }

    public String myToString(){return day + "." + month + "." + year; }

    //TODO
    //monthToString
}
