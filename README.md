# Poe Builds Cost Calculator Service

## Summary
It is a service that calculates the total budget for a Path of Building (PoB) setup in the Path of Exile (PoE).

After converting the Base64-encoded PoB code, it retrieves the prices of each gear and calculates the total price.

## Example
When pobCode is below
```
eNrtXetT3Di2_zz9V7iomvslTaK37Gyyt3gFmIGEgZBM9ktKtmXw4LaJ7YYwW_u_3yP50XbTbpoA2Zm5s1uVaWTpSDo6j985kuxX__t1kjhXOi_iLH29hp-jNUenQRbG6dnrtdP3b9bdtf_95-jVkSrP30Wb0zgxT_45-uGV_e0k-konr9c8ueaUKj_T5YeGFP0MpC5VWp7rLD1Uv2X5bha-XnubpXrN8VUaxmXzV5CoonirJvr12rFKz3S-5qgi0Gm4NXtgBhDFaWgeBucqV0Gp8wPT-8a0zA6zEOpEKimA3ETF6UkWXOhyN8-mlzCrNecq1tdVpf3Do3fH7ztDi9Pu0GBqP7w6StSNzk9KVToF_PN6bQM4pM70XlwCKZVMgY5HqPccC-xSScXai6XtNqd5UW6rCfy8X_uTS63Dtgl9zuRQzaNc70SRDsr4Sm_lcbl1rtJg1pt8jt2hpt9Q_XCalPFlEpvVqJvg5-7g4PZudYARGqr8PitVsn10Mps2Qdx77nqYSy6ot7xdNluhwR4-xuX5ZgKc_YZe9s_SuNTdhsJz3eeUMuoJ4bp8Wae3G1MPMfc5IdyThBJ3WeOjLC6y9AGM-YZBb02TBPS923KQq8e60PmVKuP-IAfrb2UTP07nFmE1dmzkWr2LKnk_VmE8LQ51meuipUOe06G2hypVW1kxExO-rOaRzsEQlb0G6I4GJzrIwHZ1m2D5nK7Sz-LWgx0exJFevea95lI3uO9ovm0eOyer1rs34W8b0DFY6tVqnmTTZMWaZcdYUjKsRl96NfGgXm_rr7NqrruEYK8mGRzhftqV2CWK_qVXE4vhEV5lxh7M9BLxpVZqZ--oW5dJMG-cEs7EIBeOzm-KOFDJofoaT6YTcDXv1YVOOxNxJRkW2bPzMgULN9SaYTrs1t7Euf6mhltZEn5bw3OVFUMt3SVO1ejmrAuw-UsQR_DS1N5PgxkPxVLCp2lubX8HqizrwjQ5BmU02MhP9MptZt3USr0Kmqg6O9Np3eNNZ1KEPRfL2h1oHZzvApo8VqVezfx3tYIv5bGp3eUxx8voLmAx5Xy1FvPcoghwJMGIIsSIR5YRWcw5wpe713vybSfV-dnNyXmsk9nsiFipfjO2LXW5SlPL-W77npTz1XpcxJKVBntPvnxUebiaq1qt1uKRD0_6ShVd2w0STZeLdN2ix9NhW3aoAYJDk1DPxQbDInmUZ7-ZECe5Z7uNfJJNZz6VSjA1S2dSNehOhLC7HFAV3x3rcBr0fJ43uCibCUSp84HRMhYnyaImg_Q3ylIFF9tZeKZXbWI7uVeLNuq0TU-ml5dgd4wYrB7xGT8K0UPcQVGS3135HchxV-8ZWeZvV-5gVnm-gyVIpwUSK3cz12K-r-Hgx2KAuW7WCV6h-nwfd6_pIdiKCfgOm4c4zGbmiD8XHA_nLd5A3LhSEGgr9kPTwbpH2TWM_9ykmYr71QbENJOSwaHkOv39Zp7-atVX6mAnDae50YmV5zDfottN44HfxxMwpEWxrUrlhDXg_qDyWKUlsbmvQqs8OD8AAXijksQHk_B6rVtq_ppriE1DQ__VC5vnM7_2J5dZXjqJKsqNIMimabmnivPXa77gInCpDDwduIJSTBWjEgcSREZpwiXjLo2ku2abHmuVTGB1ttYc_dUQPFJ5edPm7kyVrSa9V9GnnIYBkp4rCIdgIFLE9VHkR8LzkRsyzTzOsQxVNV5LDqZTlHFqcxFgBpNkzTk5z643wivDzPdZlhRtj-ryUqdh86el8T7X2lGNUQsMLyyrzR_OBEYI_rNSESDzbwooasykYOQ_438Lzok7FkyYPzgVmI8JMMU1f3Hm4bHAyJPwF-HYFVDRlfw_vXTnfmjW1kkzmIOxmi7xxtSlzB1ziQQeU8B97phI4PqYECzZmAkuoU9uasIoBB9TgqArIqXrjhn0I8aYMYTGFJgIQ7BjZJgRBL8BCI6xcF0C9bFpKhgaE-QiOfYIgpauFN6YY4ygJXUZHQsExMYUw2qMOcWYjbnnAnXMMIwJS-kBAWH5QCRjpg8PpkqxZ2pSCU89xqGcYQzzIZxzGAEWEuoQj0KPGEbDGCBUOytoZQYLrTzoCwjQMWHMM0NDAogRAhOkBGMJvHY5MIEKQsfwD8Hjag04ZTA0KHFtJxzDYAH6jjGCSmMM4srGrkeBGCeGpEup4Q1EVGPGYcxAXgr4lyJvjGEUdkgUepKehBqIcjtSYVaHwWw8F9aICgnTRh4MHdYemCU8Q48gBsNCzAwUw8KOmefB-jFiGrpS2o6RaW6IcGCM6cYza4LNIsHg7NBcqM0odMmEWX4kq0EYgtzM1gP2wZysZMBsgJxrpEdyw2GGCPQuuJmT5wJxUCHoEvofV5JZSSsmLiw7BQmCORCoB2sljRxID0QFwbjGVvwhQoelZAgWeQzyCT0TFxR_DL0hZlYL2sNYzdJTCiOECUMX2PyLmRFqkEAKggwia9hhRBWiM-hTEOgIOAudgqoI4IcnQChh4DB9gkEasYdAPrERYWPUTI5H5TcbtxSqBKXubE4QWu87mMfE6vcPr06PD-yPH87L8rJ4-eLF9fX180tVnmeR_gqo83mQTV5cQiOwDOvFRZwk64bsiw343-bZ_tHZ1uXbJPhd80-HH_2N849p_uvN-nXifSQ3hxnL2C8_TfHnz_H570dC_BLt_zyh6xunp8Fv3kVy_JVT_mn9-pMme0d6Ovn0Fn19E030mXf82-edI1_x9cvft1M3P7qJ6NFpsJvvRO-j9L366SccFTvq8MPVpRf-uiXX9_XbKHxzhd5uvb36HLx_6_2CL-KD-NOXr9Mv-f6_os_FoTzN9xEt1G_qc352nby9OOOBPJOfro7z9cvt9GtcHIqdnz78dJp9Fm-iDfUbfnOoLt_ub-6HRL5f_3qx8W5vf_rll51PR_86Xj-4xp_ev_mUZIcB-Skmh4c3G_8Kdt_8nP5r5_PF76EXHLDJ220IR3_Oybq-yDaj3758-fjx5tPkXXH586b_QV7L92-upzdvL8qrlPH19bN3v33c_ZRd-ejSO1Bn-xsnp5v7GzsnGyf7mzsbO2rjJNv86ez0X0dXn5nvyWP_M84_TQ6mX8Lftqfn2QE7e_3aLuiLZkVfVRtCRbW89V_WyJr1t3q45sSlnpg_65Dldj0rwrN6fKie1bJZPTJYz1iVWT13mB7o6KweRkMVrYnsVBzu2Shcp-JQPWOyZtW8QcYY3eyQG6RnTdasohjs15izWT02TA9cwKxeDYpg4bvr_coA3zwGh1pBphfGkVtwYzy9-fE2K7WtawqbP16dGA0vnAJQyq6eFJs3AFPfmEB-bvOihgqm9okuK8zVbfN6rcyn2oCsSE0TU_7LVCWxgT2oW3pQbaamWT5p85lACpCLCasqiu9vLg0u2Dg4qJ5sJGVNzHTXwJgKrtQDcuKwgTB1od0i3ZiNekslQWHHHadBMgXWpjWCh9HEiYFlvhmZ2Rs2KbuwmVGRZCZRodVlljpkbZ5u2-0Pr2B0dePdJPNVQmrK1ooa0DYbQ72nDCGNc1Yt66EuVQj49sU-rHPxwsz0he0Afm3rMgOkp7e1suGJxa-mUf-B7ed28ZdmIQjqjMUOo35UtbFLtNabAW6YMMcTC43r2aVqUkPIplvH9vviDq7ULODLOdAKhYmJj3Sqy9xC3qNkWvRYseB53bjDmLpkIa0emx6XMRvXJomtQ8d07HR6fmwm2fzEFiBtFepbHJp_OMie21S-B29sr07d7czGmbHdrdaW6Dcp9mYW3jhN8uyWbhsCqy2R4cwKqvwmUZOJ8mPDwb789h60S9IvfsJ16HX0yGK5Nc0L_S7di8tbQtl_NCiS8xS-h0Du6a9lNg3OV-XGihKwk9h0k0rApVykuujzY8HTlhcLnj0hH9renLa7R2ZEGmldb47N5t8WzqbdFj3lbJtOVpwjFqupu82g9RW9LpqpeF3wlMpddfG463c0TePifFJvu7Xz6xa3c-wWPuE8O918NwdSI0P8MO-xGhDczFJ90Gw5tBzvlLYM75Q9Ib9PUw1QcmULiVf0FxthGBt4pBIbLvQmO_ds0GPcovGlE488su2YXJpE_MpcICuyYTfXgKbz-iCinu0M9l3GcLVB5iyj_HR8qnt1mm6dbr_fTV_3dDLR5ffQ1j2TRu8tVV3SLkf999OxvOrgxaNOC8I8nU_qrYf5cLT7pBuPdsufbrr9jlacNr23Vfr1aMAk_Xq0gj0yrZ_QGKWJ2XXV6SN7-w9KJbu5mnM9ndJ2wp2yp5um6cSpevlulgPGeWUs5AMsB3ZX8_Mawp38ou_lm7KZj29Kno7NTRcryhL728HfIyzehTAzzwoY562wuP9o2I_PUZhBPfpkYfGsz0eOlbYBHoSbKk2rGxczr9It70QUuQbfppPmyRPCXDsCp-7oewcWxDm5NgdanjA31UrkfhrAVAsdbk_z2-791tNBuVxA5wmXp-3Nabt75IBkJ4riQAX9QL4pHOTCrNUTmqamj7-yWFbXGj7GaX_3Y1a8gpPYyrIkzK6fVhKrETl2pN89AfEIC7JaAPBWXx-dg74dT_v2oVferkSv9ClzP6YTx_TyZGCl3oUcgCv10xVksaXzlGFAdTT1b-B2_T199maWlQ-MEFbLvQIfVZ_9TdEMIdUFT6lzVRePm1_4EJe31WxWOIsz26InDDObPlYFFN5KUzT3i815-oVbQLcftlPeKApzMistDtXTxn1NR_8DrqX4R-HY_l48sls3RO2eXm_6bemgAem0ezoOmE6cd6ljurllPuqfJ7q0R2yqQzTmpzUgtsZ-ejktLb3Xa5O4CD770ygy1_NhPmVuXz2w8-bNztb7_Q879THnbhM758_pdOKb2Kb6b3uG6dWJtvcvnGLqF9VPI6r62g5kG5geJ4WZWJKoy0K3J3_tKZl65Am0W0LN1oK5Nzf6F9OaVRimtPNV5yXM96PKgzzWg-Nqn98xqKpDc8HHHAsfomYuyQ8Tqm6NbJmz2vaa0gCn7JsJhqkYRR2cjnm4pO3-5FIlgz3XT-_gRGnOSYGwxhACmBP1y5fcnKqqai3hSxBABGUilsH13urgioU07FsHhghUD4cbVy8AGGpdP13CVfvygUGuVk-Hm2_rQA3OvXo43Li9-ZZVpmkxlbbWEkpvs9QKOSjNRpyY3czBld1JdFtlmOC78lzn9Wn-IUqHYKOaKksVJ4_9aTmsxp0aS3hlr-oOcMg8G25a3UAdmIN5tsQS9S5hDjC0W2eYVHVvcdCQLWta3VMa5F9962nJEtRnlQbYXz1dwoTmyuPA_OvHS5TE2t-NqywOq_3lAXWZq7bMYGTBxcPJ2Bt9Dyczf8Xv4RTfJKq4GFzv-ulw89PSnslaQKWCLysRMUr1MApGtx5G4XgeSMzaHi-HENZ-AabTwOilBqyts2R9y2k6y0o-iJQd1mJFmE3tXrQqU75wpvemWAlo_fqEZTJcVbmDEPiivSVoZzVK7Z3LPa0S87afLHkYwVuviXjQPCF0V2m4ba6QP3Ci5gb69BKINSN7twiuzpZ0nuqrF00gYS_qGWhfX2Y8KXOTfPg9yyafbNRjfh20G9n2ID2AvO0YWJ1bEWn6MRV_bS5ivrIBWX2q3_xuDvVPC12nVW1W0RY3yQvbqHvS_hiitvLmpXP6dv-X053RoTFUEMU5b1Rcno-aW5vOT_paJ6PTNP4y1c7-9ktHceRKyWVI4B_XCzwahpHnYoII_EIRwirASHkooEwg7nqMMEllgOFvaKBGdiB21i8dl42q9yO9dA7MDdIRgOckDkBYXzpotKXM6yGcMnPOkiyPoxvHk5g7KTA0MqOMpgksSQrLU0I1_wbivbNz570GGip3trNJnE6L0VF1H6pw4tTJbWeOyrWzlaUwpbxqCArctCtG7EeTP6p3JcyrnJxqiZ1LnTsYOc1bY0a0W7HSDyeLHACR643eOQ3Cc0DKAJ9MIEi6RWcPQAPML7CBKoSZ9iVzMFb4F9b8OV-r160OZQdrkDtr0DtrsDtrNDfGbV6gL1qkL1rHOwf7W6OPqgzAPjbZiJ0bPTrK42ICVjy4LV48iHyhvBBTgZXvRlGoPI2476sw4lJQFAitAh9JSVgYhIEfhMpViFESRhp5bk-8JB8dxJO4tEL00sF98eLd5ZtU1sipMKRTgcjFVYw_HolFT4yfHbk_OqrNkjrN2xcaGWrfv-Bcn8eJdpQVm0oKeydgRtT7EcTcXOY1t61zK1q90QGtwN67XkQK_Ix5AV6qR7gnz82NeccGyAta2nMZfypJXFJDDMsq7cvq4cYuyOruFPB_rNrU2WleAAsdc-N7Yvhv7MRP07MznadqWnbl1hceltoV2BWuq1xCZciZCogIPJBaKRTGgniEI19F8Et6DENtgqmm3GOc9s0i7UsqQd0lNPLn2Jel6AoKwbRLPdoxr01xWH3HtBjPqmjHEIDh25Ym-wLWSNcVH2mpF7GYLfQ074GCvf1aSWEMD0cf4F_D99v2ICCRUp5irtJaUxcpGvBAulwJzqSOPOFijDmE9xHnVDDXC8EPUQ2GwmVa8L49cEXrbg41_HfSZ_M6BhX8CgoHw62MdOdvYPNGAtGOMnrS9SkVxb4zmNOy1uCvSuwZJtz4vSanA-UmDbeQ0CmYmSWkyI9ObmzOaqO6g9gfxywskjf-uCotCY1AUanGBIdhyCMZuX6AMQt9rrVAikcInnLhhxFCSgscSPMqiEgFgcsjvy96-C-h0mLOw28c74w2czXxwYvsZZd6tJXHkyJboMiRADwoKFZKeKFPFAKLyT0hPcwxPMFcmBdR-B7xOJHEOHmXRVhBEUOeiMQSA0lGW1meTy-N0G4mWRY6gUrTrHR8DTyOoJp5AoO6yaYjwmcKMcNsJ-dZcNFUeeYZ3QO0rtOz8tyBUMDZT0udJPGZQeUjOYgK0HNqV6X1-lWyunH-NoEIbVRRVW-H_QfHdXKxIT9XpfPxPA7OnY8wIxsBDa-_8ngU-QaooUjqwPV8D8CdR4QIOcVgrhVnjBPmRhAeh24UMukRHGlKI_gRonlDvgTYfavaVIfEnPpa9bm60oDlnc57Y2HBUqibW_NoXt4MkgEC4wT2cLx5VUti8H1PPuqlLw13jFjVQcBo5yvYoykEIoZALaUtBfCEYJVz5awDLWhkjFQL0qoso0lb_MHtsbvAWOyoMzAVu0k8meh8ZIM-ZyuZWph7S2Yk4xF3MQ09xPyAaKJd6UeRFBLiAa4JAuMQRBSwFdISCYbcAPkRiwTYYMoDNG8z7K9j_eWlw1BXZOjo37CoETD3PxthWDhu4_tqWZg9Jg5UmPnGRlZMQGlH79T3-nsEzQXZCfjV-VZnwMsSpJd05cVeM66EZrSkrUqKrCHwjFohsW_S6koHXjRYJy6crVxD-JXlwzUgfoCIFLCCQR3wB0TGN8O1Z_HcnrlT9BeLHpbUkMPC7y0Q_i2V58a5n0A8N6oQ6LDwhyDfgkmfMeTTyPUCFgUhUoH0iU-5UjoMGcQbPgUkTKkPEYXCBHyojjD8G_Alwu92hZ_NCT8fFP7B9Vc94b-P7PfCaJuFbpxyk-cdfTIGtvXn9jIxxK0xOOYTiF2NnK-oJv04GEL1PuIyu8mrkuo4FPQczzyKgdRVCm6Jsmh14XyIz7LpEv2DuOgCysHfBFlQu56VsML30a5H1J0lNdxh7cLoEWLLEAnMCMeej5WULoJQUrnCQ-B0KCdIYYVcGkgVciEiirHLTE6TBxFSYRBGdB7g_x1b_nVjS7w4bX6apqoENiYQIZhX-gVL5c1FnvRC7LtuKBiDkDIMAp9JBIA3lL7nMhS6CtBOSBkHKOwHUCnQkjIEVVjQz23OchnWXA0DYjwinYWqzmG05rWJeWYis9D4tctUWUDAxeU5CM1o1_xlbGPi-Fk6LWBFwRZ2V3o5uf-CWVu4uuRxUweUhQBBifYowwgCGaFxIKgAtMoFQtIPALC6oUJBhKXWLNQBo4EQHgGQ73H9l8wGYjoQRWqQSV02TD4yQWS18fMRIu_e3oCnOQ_BZgvhY9fjTDPfRIyu9gQKKIowwkpzEyWAKukAuVr7ikQBmHct_TlExEf1UW7D0xq2g2df313f7GAlTPqq1M-mV--9qdH6M2zMqm1qUwqWpKlknbo5P2nNIljf6kWqVdUCnFZsZAhQ1KyJpXt9rq1yNlkEC3pA7wqn2uAbVyUKMAgQrRbQae5KjCyYo2ZI_NYuhDH_lmZxi6gdI50bIu6JXD0ca-n_9HtWmC1S_Q1fg7G0B1sbwQRpycvfa5AK62teRavPKozaTVhTl3ieG3nadX2w4K6CuBQEluMIwlUeicAF4A6irKUgIYSxjAQBYA6QU8Q9Gc6DilZICRqE8GQGuYXXXSltsfTsqTm8VpikRv3CXiecmuOsNeYeUXfmJ1r8TfgCipT1drlm75uZhZ_zxP84kHOhGPCF1umXqQYdrG39m8xcWxxt25f33sAaKXPwY1Qfu4JlgMCr-WsTuFV_2ACilJcmTPAI7qGBwIsiDDCSgWS4modMueD2AQLIgEgamJcVgwhFKlQShIQBbAOsqgkGcMBCOpdeRj1Bac3Z5nr1_931jx3p4d6cRyG4t5VdTaEGhqNnwlqRXqLzWZWXssmKTsbhGRVVKiJLenmqZ7gqb18q3n3Yzcj2YeQI3wF8wZnOjXbsTC9NT5L_OFpnCyyfzcNFeTYxp8MLs-O5kcaAUYr_d1mLb4y8xIr2EqJzgy1ae2k06F0egsJ0s8JuCGoBVlAxTkJBKIkAOUkRejRSkZKISiEwl0RjBgqiPRdFgIndAPuer1R_V0CQ72st6arWcpY-7Iq6yUCYTzNZsFDh4ntYTPLf3kDH8qF4DiFPMKwwR8inOAzMe6q5DBTYusjVgfC9UDMTBblcSu0xwHA61ADnfO4hQmU_HvIG8dzuMjxH_l_iOfLXxXPuIvt0cmO-pgkux7i3JNfZzEypy8tz68aM5tV26r05C9fbiZBhgEPiKROvUz_0IFQDCfSwL-E3I5QpjiA8CUmkwdH7EQpCCOh9oSLiEdkP3V3ZEUjB-jsRmN_ePRrhRVtK1dkdu6dohm4PH4nBrclnTHZ3NWc26W2WrpuLIam231LsbX-t2zb202cze_XnFxFvoeU61mYZFKjD73EeN_LxJov9RI-O1BSeTKaJ7gX6QWhgHVd-gLAIYP2FYjoiIQVZ8YV0lWYR_EsI5aELlTUOCI4EQD0ufIj-b-1qzgyVGPBZTaamMHuvBWi3TblsZ9lk1I3xn1Paz0vXAf4zTNAtOEdXSSnUx07TsLJ9VkC6Dq29PQJtv0xBpezBxz__oUa06FTjIWigb84ajPa0urpxNnXSEwwvAu0Pic9YhBH4M1_gAGshTDJZKhQQEdnNTEFD1xUioFJ5kfSkxhA1RtyfPybbATOs78GeUdJTbMDg5u829Qor7i4G62bxFoB1mFocOPXVhQq_FZ0dmFMQERhOVE4MdmHO4upZaqiVyY3d07YnbOO8t8NTmL5N6nEBgbbKrFsQJ8D_fxL_tAQ2kcWJ5Cpr3BidDzpORke50mWWO1u5df_2chAsvxD179shpsDgWnpnREFAAPx2L0YtaAUOqr_rDtpMzMdFtPB9QpRHQiiSLKIIe6EnXAQoPFTUnLUDIVYs0pTJyKVg1yQJ533dDJPzGS7bXT82YWnXEbp9uV6Et850CfDIA2tlgfP_qMnlP7oHNJzZh58H4ZshNMKsn9GyDLW2rX8AuNEdk8NemOQY1c64Opxrj3dDXGk3VOzBjsI5TZNpcHFTu2tTaC2nqhXHwo4dsJeXlyDdZrPTHCbY018v8wyIxtFAE3Oa3UTT9uUFI3P4xkQqO_bUSD0mG-U2N9KNgYgvzI7LEooJqHVF8A-13cieNvdDyEKV_FllkxYlVnuJFhc6u2oKls2c8miUkmI0qJQIcdI_4c5JhEkkMaOB9s3mIjWhDQmE61EeMZdGIYQ8HpRHQehSD2Cnx3yJXU8RrAez2MTthj32_1318ubchlWP-hKOU71kuAl0R8_kbYzwjNCFbgQ9N0mf1Q-91eii-sxjJaM9rBGbkLs5ChV2MQ12jptrGHVwFIF51JYORcjpU-5Wm-_kzybeDwrUyfDGy4nFaSOwbGdmV-_YnmirTV8r25IMyrbHjcNp8p-m5mD601btZn6YQr7n-1RLCr9wxJUWnvSF4K4nJVFSEel7SGI_kqE2LkihUDJwNz6haHgzR8604OP6R6eb95RoPvjveQF7mbUVoNGeMvF2c6ALYHfz21poAN-AiZ9V7qHuvJ8mqF54UfmbhaUG3VTHSprSOvay8npjPNKhAqu8Z_ImGNMhj1WxHCK8H53qhr8Zkp3M3yexQvtp1EUZywSs0gSMWGPizVY2LGk_YWlf5qC6cuv6roxIANhHEyJx5HKtAHaFWkcCK5BfHWihpFQyRJhgj3taCRKqUCmuKdfzwL6TtOoYazkQ_En0gIRlN1hbnrAUaHg_4E-VpCR8wTG84xhQzqZR361zXZj9BFiBsp-YDpiiAhlQa9LOJMRBKCHKFxDrhywSAoI2BkA5DAAAU4jaTN6HI4j3pQe4OVTDIBh1QfBuz0f389R0OAPZNS1EDGYwbcoQVynD2dbLijlDjPqn3gcH05yTt6MZqjU7CbS0WgXOe9s-5tJ377hKc4K6FftnZAU2_b27s8ruDlm4u3NizzjZZYyvzBEYi7SW7-wwX5AgVJoJRFWATbIUwCwAXqqwZq5GhHpKhB5hoQTcKzgOPObhCAyrUC7xB_07RYPZUzTqb-hsTMzroRqPDmCvu2XTAkWb3GqFqYM3FybQ7mP-nvjUEpELjNseIFtAxe9zFSej7VydZWkBoFw79vV2LarDHA-iOiKA3y2qMzUHUZ2t2l1111U4IArWGxY6igLk-YFvNnNQGHBFGIloEISRIorqCEBeKCIRUhZyyrlPyXBwg5bmDnjfX7orpDP717yrO7nVFsi_I_N932luTIvr3g6EjH0KWqDVvG9kbvOI0cU74XTgsD5xh_e65yzi3EZ4J6CvdzVMwkzb158ZKdcmDbdQwAm_lR6eGVWGuzO3uwt_29B5G7qkhndnjeY7mQt1210YtG2k5szJRI0OM5NhNQf3TO6mdxOZAmAJzbdrA8LM14sBoAiXsCgUSFPPDxWLqLmW7HGCfBSCOaaRT30mZBRQguZPmXbgyXwKgfREZC5zRu3eUQ9C9Pe2zCvcGvnmXY06M0GPcuwX0msoO9s7ta1UdQ-gUjmTNMvrAnsI1qQQtHmjYJ1hztshdkkWf8gj9QtlwVv5iFoMcG7BuQuw9CqE0DLrCorBq4HwOZcerIGrCYgMQFeXBQx5gR8gMO4RIdTsZzIK1tnkeMG8CwI_IhX-FyOZ1Y9ecLkgav6TRDDm26hD73TpfzQ1yUr7jdkj__T4wLxjpnoR5ezzVu2Xb1vLNtTGbGQ5G_5NUagm4WG-nNoQQHe1b99oPUeD358GeQQa1Zu15wmJR5iQeIQJLaRhH-2HQGD-A8sVsequVeeby01nSwjU3zXuEuh86niewJBoGAQ5PwV6DzZUn2-ap4DvQWGRdH7TQiySCv4IUoEfgQa7J0M6X_J-mFo8hp6vRqN6eVXzequKYuWxOouA2TdJJHmgPNEHzqCzfMS7awDVd4keIkWLlUrcm0Jn1Phbpt0ZMxHLbFH9NfuuLep84H5FW7SYb_fR4OowT0favG8VefoInuA-NBbPnT1QbDtqg5euH3OlcPvrVxfdY_3sjnO3S_deprsja3Q1dnVakG8yK_yB_O2sMGHLfTUSaN5X26IVnT34dTlHoC5akQDxPDynoXXRPVZ4sV0iD7ZsDwcc9_Kvi0SBrQjbBJKUz1m6qugefFzqsem9ptJ-Lf3x_Q1_LBCGH2dG5KFrLO5LoKPe8tssuHicqfMHu5L7SJU15F3f734Tu_Ej-FD2WOEhf5yFEA8EouzBC_lQKPxIykhXDXOxcOlcmFsV3d9ekgfby6WEviXo7KAdutRteHjOfVcl9wrV28Xo9MofpBWPJAzfrKUdG8OXJ0skn5eiqmhF-EOJFPMEqqL7rMACdXo0J0kewVo-Bg38WBN6NNN9m1CVVG0-92MvMdiv_WRpFJ_d-nbPtNDVWcg68bzm-FmWaJXWkP72135MctbegzbnEm6q75SEi5sdJSrQ51kS6rxurE2b6ls17YeCJELL65sjvfWnXNpGfHmTxhS0HyOSRLh399J8QahpRodHVsRncfIusjssJ6WyrJv_9NHtVpP2vPbH2Fym1uGJ_bqP2bc_0UnUoXHHDKuhHmdJYlPsXXYub9h-VKNp4FL3DtY0J13n2YOJx5p3wNfi9erFkSrP30Wb0zgJASr9c_R_WQh4oA==
```

Result
```json
[
  {
    "id": 0,
    "rarity": "UNIQUE",
    "name": "Militant Faith",
    "baseName": "Timeless Jewel",
    "uniqueId": "a5087757d275789c93ddf9812023dd0f01ac10a90c3460589424737c1c34578a",
    "radius": "Large",
    "itemType": "Jewel",
    "itemLevel": 84,
    "quality": 0,
    "levelReq": 0,
    "implicits": 0,
    "allRes": 0,
    "implicitOpts": [],
    "options": [
      "Carved to glorify 9715 new faithful converted by High Templar Dominus",
      "Passives in radius are Conquered by the Templars",
      "4% increased Area Damage per 10 Devotion",
      "3% increased Effect of non-Damaging Ailments on Enemies per 10 Devotion",
      "Historic"
    ],
    "optionsById": [
      "explicit.pseudo_timeless_jewel_dominus",
      null,
      "explicit.stat_1724614884",
      "explicit.stat_1810368194",
      "explicit.stat_3787436548"
    ],
    "optionsByValue": [
      [
        9715
      ],
      [],
      [
        4,
        10
      ],
      [
        3,
        10
      ],
      []
    ]
  },
  {
    "id": 0,
    "rarity": "RELIC",
    "name": "Watcher's Eye",
    "baseName": "Prismatic Jewel",
    "uniqueId": "5cfb6a9d1361ab8ffda9e05bbadf57630c6eacb07724dcdcbcda8a0432dfe098",
    "radius": null,
    "itemType": "Jewel",
    "itemLevel": 75,
    "quality": 0,
    "levelReq": 0,
    "implicits": 0,
    "allRes": 0,
    "implicitOpts": [],
    "options": [
      "Limited to: 1",
      "5% increased maximum Energy Shield",
      "5% increased maximum Life",
      "6% increased maximum Mana",
      "8% additional Physical Damage Reduction while affected by Determination",
      "39% faster start of Energy Shield Recharge while affected by Discipline",
      "14% increased Movement Speed while affected by Grace"
    ],
    "optionsById": [
      null,
      "explicit.stat_2482852589",
      "explicit.stat_983749596",
      "explicit.stat_2748665614",
      "explicit.stat_1873457881",
      "explicit.stat_1016185292",
      "explicit.stat_3329402420"
    ],
    "optionsByValue": [
      [
        1
      ],
      [
        5
      ],
      [
        5
      ],
      [
        6
      ],
      [
        8
      ],
      [
        39
      ],
      [
        14
      ]
    ]
  },
  {
    "id": 0,
    "rarity": "MAGIC",
    "name": "Guardian's Ursine Charm of the Juggernaut",
    "baseName": null,
    "uniqueId": "b6917e8618688a8237d54ac26c976376a11629250baf1627941e86213e359453",
    "radius": null,
    "itemType": "Jewel",
    "itemLevel": 0,
    "quality": 0,
    "levelReq": 0,
    "implicits": 0,
    "allRes": 0,
    "implicitOpts": [],
    "options": [
      "20% increased Life Regeneration rate",
      "Every 4 seconds, Regenerate 20% of Life over one second"
    ],
    "optionsById": [
      "explicit.stat_44972811",
      "explicit.stat_1242155304"
    ],
    "optionsByValue": [
      [
        20
      ],
      [
        4,
        20
      ]
    ]
  },
  {
    "id": 0,
    "rarity": "UNIQUE",
    "name": "Transcendent Spirit",
    "baseName": "Viridian Jewel",
    "uniqueId": "c2faa9a48aeee380a3c5c785a6547ef9681115ecaf5536489d0233e63084e658",
    "radius": "Medium",
    "itemType": "Jewel",
    "itemLevel": 86,
    "quality": 0,
    "levelReq": 0,
    "implicits": 0,
    "allRes": 0,
    "implicitOpts": [],
    "options": [
      "-1 Dexterity per 1 Dexterity on Allocated Passives in Radius",
      "3% increased Movement Speed per 10 Dexterity on Allocated Passives in Radius",
      "+125 to Accuracy Rating per 10 Dexterity on Unallocated Passives in Radius",
      "2% reduced Movement Speed per 10 Dexterity on Unallocated Passives in Radius"
    ],
    "optionsById": [
      null,
      "explicit.stat_1795365307",
      "explicit.stat_100820057",
      null
    ],
    "optionsByValue": [
      [
        1,
        1
      ],
      [
        3,
        10
      ],
      [
        125,
        10
      ],
      [
        2,
        10
      ]
    ]
  },
  {
    "id": 0,
    "rarity": "MAGIC",
    "name": "Guardian's Ursine Charm of the Juggernaut",
    "baseName": null,
    "uniqueId": "723f2793e121ddd5f7f8bc114db5ee60a5f093e56bdf00ae61c73dc0facc85fb",
    "radius": null,
    "itemType": "Jewel",
    "itemLevel": 0,
    "quality": 0,
    "levelReq": 0,
    "implicits": 0,
    "allRes": 0,
    "implicitOpts": [],
    "options": [
      "20% increased Life Regeneration rate",
      "Every 4 seconds, Regenerate 20% of Life over one second"
    ],
    "optionsById": [
      "explicit.stat_44972811",
      "explicit.stat_1242155304"
    ],
    "optionsByValue": [
      [
        20
      ],
      [
        4,
        20
      ]
    ]
  },
  {
    "id": 0,
    "rarity": "RARE",
    "name": "Bramble Hope",
    "baseName": "Crimson Jewel",
    "uniqueId": "f6346631aa69db2a0b69596791513461562863b92952726eac84f1a63b4096f6",
    "radius": null,
    "itemType": "Jewel",
    "itemLevel": 83,
    "quality": 0,
    "levelReq": 0,
    "implicits": 2,
    "allRes": 0,
    "implicitOpts": [],
    "options": [
      "Corrupted Blood cannot be inflicted on you",
      "25% reduced Effect of Shock on you",
      "+9 to Strength and Intelligence",
      "7% increased maximum Life",
      "0.3% of Physical Attack Damage Leeched as Life",
      "Corrupted"
    ],
    "optionsById": [
      "implicit.stat_1658498488",
      "implicit.stat_3801067695",
      "explicit.stat_2543977012",
      "explicit.stat_983749596",
      null,
      null
    ],
    "optionsByValue": [
      [],
      [
        25
      ],
      [
        9
      ],
      [
        7
      ],
      [
        0,
        3
      ],
      []
    ]
  },
  {
    "id": 0,
    "rarity": "UNIQUE",
    "name": "That Which Was Taken",
    "baseName": "Crimson Jewel",
    "uniqueId": "a95ffb04320f7ec89b9ffd9266d531308a5445248fefed8fd47921fe33f792d0",
    "radius": null,
    "itemType": "Jewel",
    "itemLevel": 86,
    "quality": 0,
    "levelReq": 0,
    "implicits": 0,
    "allRes": 0,
    "implicitOpts": [],
    "options": [
      "Limited to: 1",
      "Every 4 seconds, Regenerate 20% of Life over one second",
      "Banner Skills have no Reservation",
      "Consecrated Ground you create applies 7% increased Damage taken to Enemies",
      "Exposure you inflict applies an extra -7% to the affected Resistance"
    ],
    "optionsById": [
      null,
      "explicit.stat_1242155304",
      "explicit.stat_2384457007",
      "explicit.stat_2474564741",
      null
    ],
    "optionsByValue": [
      [
        1
      ],
      [
        4,
        20
      ],
      [],
      [
        7
      ],
      [
        7
      ]
    ]
  },
  {
    "id": 0,
    "rarity": "RARE",
    "name": "Eagle Glimmer",
    "baseName": "Large Cluster Jewel",
    "uniqueId": "745f5813d904bc2e2e87bff767bba5e203b4cf3a110e706408c0bf4f60fa35c0",
    "radius": null,
    "itemType": "Jewel",
    "itemLevel": 83,
    "quality": 0,
    "levelReq": 40,
    "implicits": 3,
    "allRes": 0,
    "implicitOpts": [],
    "options": [
      "{crafted}Adds 8 Passive Skills",
      "{crafted}2 Added Passive Skills are Jewel Sockets",
      "{crafted}Added Small Passive Skills grant: 12% increased Fire Damage",
      "Added Small Passive Skills also grant: +3% to Chaos Resistance",
      "1 Added Passive Skill is Cremator",
      "1 Added Passive Skill is Disorienting Display",
      "1 Added Passive Skill is Prismatic Heart"
    ],
    "optionsById": [
      "enchant.stat_3086156145",
      "enchant.stat_4079888060",
      null,
      "explicit.stat_1811604576",
      "explicit.stat_1153801980",
      "explicit.stat_3206911230",
      "explicit.stat_2342448236"
    ],
    "optionsByValue": [
      [
        8
      ],
      [
        2
      ],
      [
        12
      ],
      [
        3
      ],
      [
        1
      ],
      [
        1
      ],
      [
        1
      ]
    ]
  },
  {
    "id": 0,
    "rarity": "RARE",
    "name": "Carrion Star",
    "baseName": "Medium Cluster Jewel",
    "uniqueId": "de20647b440b3f89c4fcd0ac7b2b35aaedd4861b365433b794a12286ef1286c5",
    "radius": null,
    "itemType": "Jewel",
    "itemLevel": 83,
    "quality": 0,
    "levelReq": 48,
    "implicits": 4,
    "allRes": 0,
    "implicitOpts": [],
    "options": [
      "{crafted}Adds 5 Passive Skills",
      "{crafted}1 Added Passive Skill is a Jewel Socket",
      "{crafted}Added Small Passive Skills grant: 6% increased Flask Effect Duration",
      "You cannot be Cursed with Silence",
      "Added Small Passive Skills also grant: 4% increased Mana Regeneration Rate",
      "Added Small Passive Skills also grant: Regenerate 0.1% of Life per Second",
      "1 Added Passive Skill is Peak Vigour",
      "1 Added Passive Skill is Spiked Concoction",
      "Corrupted"
    ],
    "optionsById": [
      "enchant.stat_3086156145",
      null,
      null,
      "implicit.stat_1654414582",
      "explicit.stat_2474836297",
      null,
      "explicit.stat_1722821275",
      "explicit.stat_3372255769",
      null
    ],
    "optionsByValue": [
      [
        5
      ],
      [
        1
      ],
      [
        6
      ],
      [],
      [
        4
      ],
      [
        0,
        1
      ],
      [
        1
      ],
      [
        1
      ],
      []
    ]
  },
  {
    "id": 0,
    "rarity": "UNIQUE",
    "name": "Transcendent Spirit",
    "baseName": "Viridian Jewel",
    "uniqueId": "d06142519b1a7780811a86905f53520a1a083c7ad566f31184c3465cf0adcdf3",
    "radius": "Medium",
    "itemType": "Jewel",
    "itemLevel": 81,
    "quality": 0,
    "levelReq": 0,
    "implicits": 0,
    "allRes": 0,
    "implicitOpts": [],
    "options": [
      "-1 Dexterity per 1 Dexterity on Allocated Passives in Radius",
      "3% increased Movement Speed per 10 Dexterity on Allocated Passives in Radius",
      "+125 to Accuracy Rating per 10 Dexterity on Unallocated Passives in Radius",
      "2% reduced Movement Speed per 10 Dexterity on Unallocated Passives in Radius"
    ],
    "optionsById": [
      null,
      "explicit.stat_1795365307",
      "explicit.stat_100820057",
      null
    ],
    "optionsByValue": [
      [
        1,
        1
      ],
      [
        3,
        10
      ],
      [
        125,
        10
      ],
      [
        2,
        10
      ]
    ]
  },
  {
    "id": 0,
    "rarity": "UNIQUE",
    "name": "Unnatural Instinct",
    "baseName": "Viridian Jewel",
    "uniqueId": "d80979d1b88d644dd5dccb470fedd7b9840d8a3d9d345524bc44dce73400fe4c",
    "radius": "Small",
    "itemType": "Jewel",
    "itemLevel": 76,
    "quality": 0,
    "levelReq": 0,
    "implicits": 1,
    "allRes": 0,
    "implicitOpts": [],
    "options": [
      "Limited to: 1",
      "22% reduced Poison Duration on you",
      "Allocated Small Passive Skills in Radius grant nothing",
      "Grants all bonuses of Unallocated Small Passive Skills in Radius",
      "Corrupted"
    ],
    "optionsById": [
      null,
      null,
      "explicit.stat_325204898",
      "explicit.stat_737702863",
      null
    ],
    "optionsByValue": [
      [
        1
      ],
      [
        22
      ],
      [],
      [],
      []
    ]
  },
  {
    "id": 0,
    "rarity": "MAGIC",
    "name": "Guardian's Ursine Charm of the Juggernaut",
    "baseName": null,
    "uniqueId": "34d0fa2e934104796e1c636b4c56007bc10e8da0cf17ee4dec43c6692aff95e3",
    "radius": null,
    "itemType": "Jewel",
    "itemLevel": 0,
    "quality": 0,
    "levelReq": 0,
    "implicits": 0,
    "allRes": 0,
    "implicitOpts": [],
    "options": [
      "20% increased Life Regeneration rate",
      "Every 4 seconds, Regenerate 20% of Life over one second"
    ],
    "optionsById": [
      "explicit.stat_44972811",
      "explicit.stat_1242155304"
    ],
    "optionsByValue": [
      [
        20
      ],
      [
        4,
        20
      ]
    ]
  },
  {
    "id": 0,
    "rarity": "UNIQUE",
    "name": "The Poet's Pen",
    "baseName": "Carved Wand",
    "uniqueId": "009641a1500b31dc503557ca241f8ec6b9de44bc48577e94e7bedefc1b590237",
    "radius": null,
    "itemType": "Weapon",
    "itemLevel": 79,
    "quality": 0,
    "levelReq": 12,
    "implicits": 1,
    "allRes": 0,
    "implicitOpts": [],
    "options": [
      "12% increased Spell Damage",
      "+1 to Level of Socketed Skill Gems per 25 Player Levels",
      "Trigger a Socketed Spell when you Attack with this Weapon, with a 0.25 second Cooldown",
      "Adds 3 to 5 Physical Damage to Attacks with this Weapon per 3 Player Levels",
      "12% increased Attack Speed"
    ],
    "optionsById": [
      "implicit.stat_2974417149",
      "explicit.stat_1435838855",
      null,
      "explicit.stat_1454603936",
      "explicit.stat_210067635"
    ],
    "optionsByValue": [
      [
        12
      ],
      [
        1,
        25
      ],
      [
        0,
        25
      ],
      [
        3,
        5,
        3
      ],
      [
        12
      ]
    ]
  },
  {
    "id": 0,
    "rarity": "UNIQUE",
    "name": "The Poet's Pen",
    "baseName": "Carved Wand",
    "uniqueId": "59e55d61466b18954e4b52488e960c30f101ae52e87840ec08eeba2fc1a7e7b5",
    "radius": null,
    "itemType": "Weapon",
    "itemLevel": 85,
    "quality": 0,
    "levelReq": 12,
    "implicits": 1,
    "allRes": 0,
    "implicitOpts": [],
    "options": [
      "14% increased Spell Damage",
      "+1 to Level of Socketed Skill Gems per 25 Player Levels",
      "Trigger a Socketed Spell when you Attack with this Weapon, with a 0.25 second Cooldown",
      "Adds 3 to 5 Physical Damage to Attacks with this Weapon per 3 Player Levels",
      "10% increased Attack Speed"
    ],
    "optionsById": [
      "implicit.stat_2974417149",
      "explicit.stat_1435838855",
      null,
      "explicit.stat_1454603936",
      "explicit.stat_210067635"
    ],
    "optionsByValue": [
      [
        14
      ],
      [
        1,
        25
      ],
      [
        0,
        25
      ],
      [
        3,
        5,
        3
      ],
      [
        10
      ]
    ]
  },
  {
    "id": 0,
    "rarity": "UNIQUE",
    "name": "Viridi's Veil",
    "baseName": "Praetor Crown",
    "uniqueId": "74ced25810e6bb22a92d4ce74f3019d968080fda39d02e87a4fe347f8364a72d",
    "radius": null,
    "itemType": "Helmet",
    "itemLevel": 87,
    "quality": 0,
    "levelReq": 68,
    "implicits": 1,
    "allRes": 0,
    "implicitOpts": [],
    "options": [
      "Socketed Skill Gems get a 90% Cost & Reservation Multiplier",
      "+1 to Level of Socketed Gems",
      "140% increased Armour and Energy Shield",
      "+18% to all Elemental Resistances",
      "Damage of Enemies Hitting you is Unlucky while you have a Magic Ring Equipped",
      "You are Hexproof if you have a Magic Ring in right slot",
      "Take no Extra Damage from Critical Strikes if you have a Magic Ring in left slot",
      "Corrupted"
    ],
    "optionsById": [
      "implicit.stat_2865550257",
      "explicit.stat_2843100721",
      "explicit.stat_3321629045",
      "explicit.stat_2901986750",
      "explicit.stat_2510276385",
      "explicit.stat_165884462",
      "explicit.stat_611839381",
      null
    ],
    "optionsByValue": [
      [
        90
      ],
      [
        1
      ],
      [
        140
      ],
      [
        18
      ],
      [],
      [],
      [],
      []
    ]
  },
  {
    "id": 0,
    "rarity": "UNIQUE",
    "name": "Queen of the Forest",
    "baseName": "Destiny Leather",
    "uniqueId": "dc9ff1df341f08e5d4a84550d87c273cc86388bfada75424125251e213454d3b",
    "radius": null,
    "itemType": "Body",
    "itemLevel": 80,
    "quality": 0,
    "levelReq": 59,
    "implicits": 0,
    "allRes": 59,
    "implicitOpts": [],
    "options": [
      "221% increased Evasion Rating",
      "+63 to maximum Life",
      "+7% to Fire Resistance",
      "+36% to Cold Resistance",
      "+16% to Lightning Resistance",
      "25% reduced Movement Speed",
      "1% increased Movement Speed per 600 Evasion Rating, up to 75%",
      "-45 Physical Damage taken from Hits by Animals"
    ],
    "optionsById": [
      "explicit.stat_124859000",
      "explicit.stat_3299347043",
      "explicit.stat_3372524247",
      "explicit.stat_4220027924",
      "explicit.stat_1671376347",
      null,
      "explicit.stat_2591020064",
      null
    ],
    "optionsByValue": [
      [
        221
      ],
      [
        63
      ],
      [
        7
      ],
      [
        36
      ],
      [
        16
      ],
      [
        25
      ],
      [
        1,
        600,
        75
      ],
      [
        45
      ]
    ]
  },
  {
    "id": 0,
    "rarity": "RELIC",
    "name": "Mageblood",
    "baseName": "Heavy Belt",
    "uniqueId": "9f98bd2b44f1041fb61c1e66ad567a0c26fe87bf63d8866c37a9f797e18bbf5b",
    "radius": null,
    "itemType": "Belt",
    "itemLevel": 84,
    "quality": 0,
    "levelReq": 44,
    "implicits": 1,
    "allRes": 43,
    "implicitOpts": [],
    "options": [
      "+32 to Strength",
      "+36 to Dexterity",
      "+18% to Fire Resistance",
      "+25% to Cold Resistance",
      "Magic Utility Flasks cannot be Used",
      "Leftmost 4 Magic Utility Flasks constantly apply their Flask Effects to you",
      "Magic Utility Flask Effects cannot be removed"
    ],
    "optionsById": [
      "implicit.stat_4080418644",
      "explicit.stat_3261801346",
      "explicit.stat_3372524247",
      "explicit.stat_4220027924",
      "explicit.stat_3986704288",
      null,
      "explicit.stat_344389721"
    ],
    "optionsByValue": [
      [
        32
      ],
      [
        36
      ],
      [
        18
      ],
      [
        25
      ],
      [],
      [
        4
      ],
      []
    ]
  },
  {
    "id": 0,
    "rarity": "UNIQUE",
    "name": "Kaom's Spirit",
    "baseName": "Titan Gauntlets",
    "uniqueId": "5c52f12f7143cebd56634e7b2c68935f483fd4859663fcd83929a94b7189a21e",
    "radius": null,
    "itemType": "Glove",
    "itemLevel": 85,
    "quality": 0,
    "levelReq": 69,
    "implicits": 1,
    "allRes": 23,
    "implicitOpts": [],
    "options": [
      "+1 to Maximum Frenzy Charges",
      "+70 to maximum Life",
      "+23% to Fire Resistance",
      "0.36% of Physical Attack Damage Leeched as Life",
      "Life Recovery from Regeneration is not applied",
      "Regenerate 1 Rage per second for every 300 Life Recovery per second from Regeneration",
      "Corrupted"
    ],
    "optionsById": [
      "implicit.stat_4078695",
      "explicit.stat_3299347043",
      "explicit.stat_3372524247",
      null,
      "explicit.stat_3947672598",
      "explicit.stat_4103111421",
      null
    ],
    "optionsByValue": [
      [
        1
      ],
      [
        70
      ],
      [
        23
      ],
      [
        0,
        36
      ],
      [],
      [
        1,
        300
      ],
      []
    ]
  },
  {
    "id": 0,
    "rarity": "RARE",
    "name": "Horror Trail",
    "baseName": "Dragonscale Boots",
    "uniqueId": "488a1c2a123b3affc09bcb8ec60dc5a242f3ccdfa2a3ef2a7d6f6d34d5355b32",
    "radius": null,
    "itemType": "Boot",
    "itemLevel": 85,
    "quality": 0,
    "levelReq": 65,
    "implicits": 2,
    "allRes": 43,
    "implicitOpts": [],
    "options": [
      "8% increased Life Regeneration rate",
      "4% increased Action Speed",
      "{fractured}+88 to maximum Life",
      "+11% chance to Suppress Spell Damage",
      "+43% to Cold Resistance",
      "+33% to Chaos Resistance",
      "28% increased Movement Speed",
      "11% increased Movement Speed if you haven't been Hit Recently",
      "{crafted}Regenerate 25 Life per second",
      "{crafted}+41 to maximum Mana"
    ],
    "optionsById": [
      "implicit.stat_44972811",
      "implicit.stat_2878959938",
      "explicit.stat_3299347043",
      "explicit.stat_492027537",
      "explicit.stat_4220027924",
      "explicit.stat_2923486259",
      "explicit.stat_2250533757",
      "explicit.stat_308396001",
      "explicit.stat_3325883026",
      "explicit.stat_1050105434"
    ],
    "optionsByValue": [
      [
        8
      ],
      [
        4
      ],
      [
        88
      ],
      [
        11
      ],
      [
        43
      ],
      [
        33
      ],
      [
        28
      ],
      [
        11
      ],
      [
        25
      ],
      [
        41
      ]
    ]
  },
  {
    "id": 0,
    "rarity": "UNIQUE",
    "name": "Replica Atziri's Foible",
    "baseName": "Paua Amulet",
    "uniqueId": "cd19215abc016ce5d6a4ef2d3d29b678ae4f78a2235d8cd1e1c21f64a856bcf1",
    "radius": null,
    "itemType": "Amulet",
    "itemLevel": 86,
    "quality": 0,
    "levelReq": 16,
    "implicits": 2,
    "allRes": 0,
    "implicitOpts": [],
    "options": [
      "{crafted}Allocates Whispers of Doom",
      "Regenerate 2.33% of Life per second",
      "+120 to maximum Life",
      "30% increased Life Regeneration rate",
      "Items and Gems have 25% reduced Attribute Requirements"
    ],
    "optionsById": [
      null,
      null,
      "explicit.stat_3299347043",
      "explicit.stat_44972811",
      null
    ],
    "optionsByValue": [
      [],
      [
        2,
        33
      ],
      [
        120
      ],
      [
        30
      ],
      [
        25
      ]
    ]
  },
  {
    "id": 0,
    "rarity": "UNIQUE",
    "name": "Anathema",
    "baseName": "Moonstone Ring",
    "uniqueId": "b34aed1786c2432558736824fd60e39bda4f36c979520b0da1e3fb3b467fc320",
    "radius": null,
    "itemType": "Ring",
    "itemLevel": 76,
    "quality": 0,
    "levelReq": 49,
    "implicits": 1,
    "allRes": 0,
    "implicitOpts": [],
    "options": [
      "+21 to maximum Energy Shield",
      "+37 to Intelligence",
      "15% increased Cast Speed",
      "15% chance to gain a Power Charge when you Cast a Curse Spell",
      "Your Curse Limit is equal to your maximum Power Charges",
      "Corrupted"
    ],
    "optionsById": [
      "implicit.stat_3489782002",
      "explicit.stat_328541901",
      "explicit.stat_2891184298",
      "explicit.stat_322835727",
      "explicit.stat_973000407",
      null
    ],
    "optionsByValue": [
      [
        21
      ],
      [
        37
      ],
      [
        15
      ],
      [
        15
      ],
      [],
      []
    ]
  },
  {
    "id": 0,
    "rarity": "MAGIC",
    "name": "Synthesised Elreon's Sapphire Ring of the Titan",
    "baseName": null,
    "uniqueId": "77dc1d29acb473bd992a23791b7d994234a509e5d2fe192bf0cdb98b6af2927c",
    "radius": null,
    "itemType": "Ring",
    "itemLevel": 0,
    "quality": 0,
    "levelReq": 64,
    "implicits": 3,
    "allRes": 0,
    "implicitOpts": [],
    "options": [
      "15% increased Damage",
      "17% increased Damage while Leeching Mana",
      "6% increased maximum Life",
      "+47 to Strength",
      "{crafted}Non-Channelling Skills have -7 to Total Mana Cost"
    ],
    "optionsById": [
      "implicit.stat_2154246560",
      "implicit.stat_1994684426",
      "implicit.stat_983749596",
      "explicit.stat_4080418644",
      null
    ],
    "optionsByValue": [
      [
        15
      ],
      [
        17
      ],
      [
        6
      ],
      [
        47
      ],
      [
        7
      ]
    ]
  },
  {
    "id": 0,
    "rarity": "MAGIC",
    "name": "Saturated Divine Life Flask of the Order",
    "baseName": null,
    "uniqueId": "4b62cdae4603ac12379cd8ceb3a1e48e0239a6d924d7893651c9491f9d06a82b",
    "radius": null,
    "itemType": "Flask",
    "itemLevel": 0,
    "quality": 0,
    "levelReq": 64,
    "implicits": 0,
    "allRes": 0,
    "implicitOpts": [],
    "options": [
      "69% increased Amount Recovered",
      "33% reduced Recovery rate",
      "{crafted}Regenerate 3% of Life per second during Effect"
    ],
    "optionsById": [
      "explicit.stat_700317374",
      null,
      "explicit.stat_871270154"
    ],
    "optionsByValue": [
      [
        69
      ],
      [
        33
      ],
      [
        3
      ]
    ]
  },
  {
    "id": 0,
    "rarity": "MAGIC",
    "name": "Abecedarian's Silver Flask of the Order",
    "baseName": null,
    "uniqueId": "a8d921ba5a452d6232fd0f76d93fafa7037661572e14d4ae980f4dc8c1b9baa6",
    "radius": null,
    "itemType": "Flask",
    "itemLevel": 0,
    "quality": 0,
    "levelReq": 48,
    "implicits": 2,
    "allRes": 0,
    "implicitOpts": [],
    "options": [
      "{crafted}69% increased effect",
      "{crafted}Gains no Charges during Effect",
      "33% reduced Duration",
      "25% increased effect",
      "{crafted}25% reduced Mana Cost of Skills during Effect"
    ],
    "optionsById": [
      "enchant.stat_2448920197",
      "enchant.stat_4123533923",
      null,
      "explicit.stat_2448920197",
      null
    ],
    "optionsByValue": [
      [
        69
      ],
      [],
      [
        33
      ],
      [
        25
      ],
      [
        25
      ]
    ]
  },
  {
    "id": 0,
    "rarity": "MAGIC",
    "name": "Alchemist's Granite Flask of the Impala",
    "baseName": null,
    "uniqueId": "8b87f2c9d0e2271f85ea187deef61a7b6ece6a77a7d0121959ea62dadaa5e35e",
    "radius": null,
    "itemType": "Flask",
    "itemLevel": 0,
    "quality": 0,
    "levelReq": 67,
    "implicits": 2,
    "allRes": 0,
    "implicitOpts": [],
    "options": [
      "{crafted}70% increased effect",
      "{crafted}Gains no Charges during Effect",
      "25% reduced Duration",
      "25% increased effect",
      "60% increased Evasion Rating during Effect"
    ],
    "optionsById": [
      "enchant.stat_2448920197",
      "enchant.stat_4123533923",
      null,
      "explicit.stat_2448920197",
      "explicit.stat_299054775"
    ],
    "optionsByValue": [
      [
        70
      ],
      [],
      [
        25
      ],
      [
        25
      ],
      [
        60
      ]
    ]
  },
  {
    "id": 0,
    "rarity": "MAGIC",
    "name": "Abecedarian's Quicksilver Flask of the Armadillo",
    "baseName": null,
    "uniqueId": "1508c6b5579eed8e27860ed84c409cbc0268f223192b435b347f88a16247ffad",
    "radius": null,
    "itemType": "Flask",
    "itemLevel": 0,
    "quality": 0,
    "levelReq": 67,
    "implicits": 2,
    "allRes": 0,
    "implicitOpts": [],
    "options": [
      "{crafted}70% increased effect",
      "{crafted}Gains no Charges during Effect",
      "33% reduced Duration",
      "25% increased effect",
      "57% increased Armour during Effect"
    ],
    "optionsById": [
      "enchant.stat_2448920197",
      "enchant.stat_4123533923",
      null,
      "explicit.stat_2448920197",
      "explicit.stat_1693613464"
    ],
    "optionsByValue": [
      [
        70
      ],
      [],
      [
        33
      ],
      [
        25
      ],
      [
        57
      ]
    ]
  },
  {
    "id": 0,
    "rarity": "MAGIC",
    "name": "Abecedarian's Quartz Flask of Variegation",
    "baseName": null,
    "uniqueId": "c382998f9e88bbc48a64066b51f03b5f6c8dd459ee762dba542cc905a2f0597d",
    "radius": null,
    "itemType": "Flask",
    "itemLevel": 0,
    "quality": 0,
    "levelReq": 48,
    "implicits": 2,
    "allRes": 0,
    "implicitOpts": [],
    "options": [
      "{crafted}69% increased effect",
      "{crafted}Gains no Charges during Effect",
      "38% reduced Duration",
      "25% increased effect",
      "34% additional Elemental Resistances during Effect"
    ],
    "optionsById": [
      "enchant.stat_2448920197",
      "enchant.stat_4123533923",
      null,
      "explicit.stat_2448920197",
      "explicit.stat_962725504"
    ],
    "optionsByValue": [
      [
        69
      ],
      [],
      [
        38
      ],
      [
        25
      ],
      [
        34
      ]
    ]
  }
]
```
