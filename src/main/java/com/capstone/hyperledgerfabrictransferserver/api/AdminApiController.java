package com.capstone.hyperledgerfabrictransferserver.api;

import com.capstone.hyperledgerfabrictransferserver.dto.admin.AdminLoginRequest;
import com.capstone.hyperledgerfabrictransferserver.dto.admin.AdminLoginResponse;
import com.capstone.hyperledgerfabrictransferserver.dto.trade.PagingTradeResponseDto;
import com.capstone.hyperledgerfabrictransferserver.dto.trade.RequestForGetTradeByDetails;
import com.capstone.hyperledgerfabrictransferserver.dto.trade.TransferResponse;
import com.capstone.hyperledgerfabrictransferserver.dto.user.PagingUserDto;
import com.capstone.hyperledgerfabrictransferserver.dto.user.UserLoginRequest;
import com.capstone.hyperledgerfabrictransferserver.dto.user.UserLoginResponse;
import com.capstone.hyperledgerfabrictransferserver.dto.user.UserModifyRequest;
import com.capstone.hyperledgerfabrictransferserver.service.AdminService;
import com.capstone.hyperledgerfabrictransferserver.service.TradeService;
import com.capstone.hyperledgerfabrictransferserver.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminApiController {

    private final AdminService adminService;
    private final UserService userService;
    private final TradeService tradeService;

    @GetMapping("/login")
    public ResponseEntity<AdminLoginResponse> login(
        @ModelAttribute AdminLoginRequest adminLoginRequest
    ){
        return ResponseEntity.ok(adminService.login(adminLoginRequest));
    }

    @GetMapping("/users")
    public ResponseEntity<PagingUserDto> getAllUser(
            @RequestParam(required = false, defaultValue = "1") int page
    ) {
        return ResponseEntity.ok(userService.getAllUser(page));
    }

    @PutMapping("/user")
    public ResponseEntity<Void> modifyUserInfo(@RequestBody UserModifyRequest userModifyRequest) {
        userService.modifyUserInfo(userModifyRequest);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/trade")
    public ResponseEntity<PagingTradeResponseDto> getAllTradeByDetails(
            @RequestParam(defaultValue = "1") int page,
            @ModelAttribute RequestForGetTradeByDetails requestForGetTradeByDetails
    ) {
        System.out.println("requestForGetTradeByDetails = " + requestForGetTradeByDetails);
        return ResponseEntity.ok(tradeService.getAllTradeByDetails(page, requestForGetTradeByDetails));
    }

    @GetMapping("/trade/{transactionId}")
    public ResponseEntity<TransferResponse> getTradeByTransactionId(@PathVariable @NonNull String transactionId) {
        return ResponseEntity.ok(tradeService.getTradeByTransactionId(transactionId));
    }
}
