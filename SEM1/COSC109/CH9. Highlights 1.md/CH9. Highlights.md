Pg. 852-945

Chapter highlights

- The nature of computer graphics and digital images
- The difference between raster and vector
- Raster variables like aliasing, color depth, color space, resampling, resolution, scaling, and compression
- Display screen standards and scanning methods
- Industry standards for Digital Television (DTV) and Digital Cinema
 
Computer graphics fall into 2 categories: Graphics and Images  
Graphics:  
Any visual presentation that can be displayed on a physical surface  
Product of human imagination  
Stick figures, symbols, numbers, typography, etc.  
Images:  
2 or 3D representation of a person, animal, object, or scene in the natural world  
Still or moving  
Photographs, maps, charts, graphs, broadcast TV, digital video, etc.
 
Digital Imaging  
Physical film strips are real, unlike digital film  
Analog v digital
 
2 methods of digital encoding  
Bitmap or Raster/ Vector  
Bitmap  
Pixels  
Short for picture element  
Color value is typically 24 bits long  
"whole is greater than the sum of its parts"  
Basic versions of the technique goes back to 3000 BC  
Resolution:  
Quantity of pixels  
More pixels = more info :mind blown:  
Vectors  
Math
 
Printing uses subtractive color mixing  
Adding colors makes black, not white  
They use CMYK lol  
Screens use additive color mixing  
Adding colors makes white, not black  
They use RGB lol
 
Color Depth  
24 bit color = true color  
8 bits for R, G, and B  
More colors than the eye can discern (16.8 mil > 10 mil)  
Hex codes  
Some systems can render 48 bit color, 24 still the most common tho
 
Pixel Dimensions  
Size of an image (X pixels * Y pixels)  
Pixel Count  
The total number of pixels in an image  
Pixel Density  
PPI: Pixels Per Linear Inch (not sq. inch)  
Digital photographers need 300 PPI  
90,000 px/sq inch!  
3,648 pixels ÷ 300 pixels/inch = 12.16 inches  
2,736 pixels ÷ 300 pixels/inch = 9.12 inches  
More is always better, unless you need storage lol  
Modern displays are 72 PPI  
Scaling  
Enlarging raster images = softer and fuzzier  
Don’t do it lol  
Downscaling raster images = artificially improve PPI  
May improve visual clarity up to a point
 
Upscaling, Resampling, Cropping
 
Anti-Aliasing  
Alias artifacts are the jagged lines in raster images  
Anti-aliasing smooths out jagged edges by blending color transition points  
Increases file size a lil
 
Lossy v Lossless compression  
JPEG is lossy  
1.3 MB compressed to 68 KB  
Usually 3 levels of compression:  
Normal, fine, superfine  
Photoshop has 12 levels of JPEG compression  
Can leave behind artifacts  
PNG is lossless
 
Raster Image Formats  
Some formats save layers, like .PSD or .TIFF
 
Vector Graphics  
Use paths :o  
Infinitely scalable  
Upscaling does NOT change file size  
2 different vectors can be tweened
 
Display Screen Standards  
Each device has a native resolution  
Built in pixels  
Images that match a native resolution are pixel perfect  
Quality deteriorates as you move further away from a monitor's native resolution  
Choosing a display res that’s lower than native reduces the effects of zooming in  
Also reduces desktop screen space AND compromises the quality of the screen image (fuzzy)
 
Aspect Ratio  
Proportional relationship of X pixels to Y pixels  
2 most common are 4:3 and 16:9  
Boxy and widescreen
 
MOVING IMAGES  
Raster Scanning  
Images are produced 1 by 1 really quickly from left to right, top to bottom (old CRT screens)  
1 line is a scan line  
1 full screen is a scanning cycle  
1 Frame is a complete scanning cycle  
Refresh Rate = # of scanning cycles/ sec  
Measured in hz  
Anything below 50 Hz appears to flicker  
Most are 60 Hz +  
More Hz = sharper image quality + less eyestrain  
Larger screens need higher refresh rates  
Large monitors are typically 85 Hz+  
Progressive Scanning  
Consecutively scanning lines from top to bottom, like a typewriter  
Combats eyestrain, is a given on computer monitors
 
Interlaced Scanning  
Scanning odd lines, then even lines  
Screens draw so fast you cant tell  
Reduced bandwith requirement by 1/2
 
Fields  
1 complete scanning pass of EITHER the odds or even is a field  
2 fields = 1 frame
 
TV AND CINEMA STANDARDS  
24 FPS used to be international standard  
Below flicker fusion threshold  
Display each frame 2x to compensate :O  
No more flicker :D  
3 Major Analog TV standards:  
NTSC  
National Television Standards Committee  
Developed in the US  
PAL  
Phase Alternating Line  
Developed in Germany  
SECAM  
Sequential Color and Memory  
Developed in France
 
4:3 on analog, 16:9 on digital
 
DIGITAL TELEVISION (DTV)  
Content is more fluid  
Less signal interference  
Less bandwidth  
HD baybee (over 2x res)  
16:9  
Digital to Analog requires downconverting and losing quality
 
ATSC  
Advanced Television Systems Committee  
Adopted in the US in 1996
 
US's transition to HDTV took over a decade  
6/12/2009 last day of analog transmission in US
 
NTSC has a fixed res, aspect ratio, scan mode, and frame rate  
ATSC has 18 diff display formats  
Grouped into Standard Def., Enhanced Def., and High def.  
SDTV, EDTV, HDTV  
Also improves audio distribution lol
 
DVB (Digital Video Broadcasting)  
Established 1997  
Adopted in EU and AUS
 
Digital Cinema Standards  
DCI formed in 2002 (Digital Cinema Initiatives LLC)  
Set industry standards like:  
Adapting HD to 16:9 to match filmmaking's 17:9  
2k, 4k, and 8k resolution  
8k is 16x the res of 2k
    
![Exported image](SEM1/COSC109/CH9.%20Highlights%201.md/Exported%20image%2020240525202904-0.png) ![• GIF offers 256 colors and transparency (transparent pixels) and is a lossless compression format. It is common for logos and other images with lines and solid blocks of color. It supports interlacing, so every odd line of pixels loads, then every even line loads, making graphics seem to appear faster (users see the full-sized, half-loaded graphic before the rest of the pixels appear). ](SEM1/COSC109/CH9.%20Highlights%201.md/Exported%20image%2020240525202904-1.png) ![• JPEG offers 16.8 million colors but does not support (has transparency no transparent pixels). It is a lossy compression format and is used most often for photographs. This format does not support interlacing. ](Exported%20image%2020240525202904-2.png) ![• PNG offers 16.8 million colors and transparency, but you can choose to use fewer colors to save file space (PNG 8, or PNG with eight- bit color). It is a lossless compression format and is common for a wide range of images, including favicons (the small web page icons in browser tabs). Some older web brows-ers don't support it (Internet Explorer prior to version 4); such browsers have mostly, but not completely, fallen out of use. PNG files can be very small, but for photographs with many colors, they may be larger than comparable JPEGs. This format supports interlacing. ](Exported%20image%2020240525202904-3.png)