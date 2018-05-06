package pp.filelocking;

public class Test
{
    public static void main(String[] args)
    {

//        File f = new File(3);
//
//        // Test 1
//        Thread T1 = new Thread(() ->
//        {
//            try
//            {
//                f.lock(0, 1);
//                f.lock(1, 2);
//            } catch (InterruptedException e)
//            {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//
//        });
//
//        Thread T2 = new Thread(() ->
//        {
//            f.unlock(0, 1);
//        });
//        T1.start();
//        T2.start();

        // Test 2
        // Thread T3 = new Thread( () -> {
        //
        // try {
        // f.lock(0,1);
        // f.lock(0,1);
        // } catch (InterruptedException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        //
        // });
        //
        // Thread T4 = new Thread( () -> {
        // f.unlock(0,1);
        // f.unlock(0,1);
        // });
        //
        //
        // T3.start();
        // T4.start();

    }

}


//Unittest
//intervall ( 0,15 ) Locked
//intervall ( 0,15 ) UnLocked
//intervall ( 1,1 ) Locked
//intervall ( 1,1 ) UnLocked
//intervall ( 7,12 ) Locked
//intervall ( 7,12 ) UnLocked
//intervall ( 23,37 ) Locked
//intervall ( 23,37 ) UnLocked
//intervall ( 0,77 ) Locked
//intervall ( 0,77 ) UnLocked
//intervall ( 7,12 ) Locked
//intervall ( 7,12 ) Locked
//intervall ( 7,12 ) Locked
//intervall ( 7,12 ) Locked
//intervall ( 7,12 ) Locked
//intervall ( 0,1 ) Locked
//intervall ( 0,1 ) Locked
//intervall ( 0,1 ) UnLocked
//intervall ( 0,1 ) Locked
//intervall ( 0,1 ) UnLocked
//intervall ( 1,2 ) Locked
//intervall ( 0,1 ) Locked
//intervall ( 0,1 ) UnLocked
//intervall ( 0,1 ) Locked
//intervall ( 0,1 ) UnLocked
//intervall ( 0,1 ) Locked


/*
 * Fehler Innerhalb des Tests soll wie folgt vorgegangen werden: 1) Es wird ein
 * File der Länge 3 erzeugt. 2) Ein Thread T1 sperrt das Intervall [0,1]. 3) T1
 * versucht auch das Intervall [1,2] zu sperren. 4) Ein Thread T2 hebt die
 * Sperre von [0,1] auf. Ihre Lösung weicht von der erwarteten Verhaltensweise
 * wie folgt ab: T1 sollte nach dem Entsperren von [0,1] durch T2 (Punkt 4)
 * wiederaufgeweckt werden, die Sperre auf [1,2] setzen und schlussendlich zu
 * Ende laufen können. T1 ist allerdings nicht terminiert.
 */

/*
 * ehler Innerhalb des Tests soll wie folgt vorgegangen werden: 1) Es wird ein
 * File der Länge 3 erzeugt. 2) Ein Thread T1 sperrt das Intervall [0,1]. 3) T1
 * und ein weiterer Thread T2 versuchen jeweils erneut das Intervall [0,1] zu
 * sperren. 4) Ein Thread T3 hebt die Sperre von [0,1] auf. 5) T3 hebt eine
 * weitere Sperre von [0,1] auf. Ihre Lösung weicht von der erwarteten
 * Verhaltensweise wie folgt ab: Nach dem Entsperren von [0,1] an Punkt 4 muss
 * entweder T1 oder T2 seinen neuerlichen Versuch dieses Intervall zu sperren
 * ausführen und dann zu Ende laufen können. Dies ist nicht der Fall.
 */