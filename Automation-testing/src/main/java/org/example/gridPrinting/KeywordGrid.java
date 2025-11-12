package org.example.gridPrinting;

import java.util.Arrays;
import java.util.List;

public class KeywordGrid {
    public static void main(String[] args) {
        int n = 8;
        List<String> keywords = Arrays.asList(
                  "asser","abstract","boolean","break","byte","case","catch","char","class"
                 ,"const","continue","default","do","double","else","enum","extends","exports","final",
                  "finally","float","for","goto","if","implements" ,"import" ,"instanceof" ,"int" ,
                  "interface","long" ,"module" ,"native" ,"new" ,"open" ,"opens" ,"package" ,"private" ,
                        "protected" ,"provides" ,"public" ,"record" ,"requires" ,"return" ,"sealed" ,
                        "short" ,"static" ,"strictfp" ,"super" ,"switch" ,"synchronized" ,
                        "this" ,"throw" ,"throws" ,"to" ,"transient" ,"transitive" ,
                        "try" ,"uses" ,"var" ,"void" , "volatile" , "while" , "yield");
        int colLen = "synchronized".length();

        String headBorderLine = "+" + "-".repeat(colLen+2)
                +"+" + "-".repeat(colLen+2)
                +"+" + "-".repeat(colLen+2)
                +"+" + "-".repeat(colLen+2)
                +"+" + "-".repeat(colLen+2);
            System.out.print(headBorderLine);

        int nk = 36;
        System.out.println();
        int index = 0;
        for(int j = 0;j < nk/5; j++ ){
            System.out.printf("| "+"%-"+colLen+"s |"
            +"%-"+(colLen+1)+"s |"
            +"%-"+(colLen+1)+"s |"
            +"%-"+(colLen+1)+"s |"
            +"%-"+(colLen+1)+"s |",keywords.get(index++),keywords.get(index++),keywords.get(index++),keywords.get(index++),keywords.get(index++));
//            for (int i=0;i<5;i++){
//                colLen = colLen - keywords.get(index).length();
//                System.out.printf("|"+"%-"+colLen+"s",keywords.get(index++));
//            }
            System.out.println();
            System.out.print(headBorderLine);
            System.out.println();
        }


    }
}

/*
* abstract
assert
boolean
break
byte
case
catch
char
class
const
continue
default
do
double
else
enum
exports
extends
final
finally
float
for
goto
if
implements
import
instanceof
int
interface
long
module
native
new
open
opens
package
private
protected
provides
public
record
requires
return
sealed
short
static
strictfp
super
switch
synchronized
this
throw
throws
to
transient
transitive
try
uses
var
void
volatile
while
yield
* */